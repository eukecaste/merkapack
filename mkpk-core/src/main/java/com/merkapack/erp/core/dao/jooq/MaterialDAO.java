package com.merkapack.erp.core.dao.jooq;

import static com.merkapack.erp.master.jooq.tables.Material.MATERIAL;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.stream.Collectors;

import com.merkapack.erp.core.basic.DBContext;
import com.merkapack.erp.core.dao.jooq.Mapper.MaterialMapper;
import com.merkapack.erp.core.model.Material;
import com.merkapack.watson.util.MkpkStringUtils;

public class MaterialDAO {
	public static Material getMaterial(DBContext ctx, Integer id) {
		return ctx.getDslContext().select()
			.from( MATERIAL )
			.where(MATERIAL.ID.eq(id))
			.orderBy(MATERIAL.NAME)
			.fetch()
			.stream()
			.map( new MaterialMapper(MATERIAL) )
			.findFirst()
			.orElse(null);
	}
	public static LinkedList<Material> getMaterials(DBContext ctx) {
		return ctx.getDslContext().select()
			.from( MATERIAL )
			.orderBy(MATERIAL.NAME)
			.fetch()
			.stream()
			.map( new MaterialMapper(MATERIAL) )
			.collect(Collectors.toCollection(LinkedList::new));
	}
	public static LinkedList<Material> getMaterials(DBContext ctx, String query) {
		query = MkpkStringUtils.prependIfMissing(query, "%");
		query = MkpkStringUtils.appendIfMissing(query, "%");
		return ctx.getDslContext().select()
				.from( MATERIAL )
				.where(MATERIAL.CODE.like(query)
					.or(MATERIAL.NAME.like(query))
				)
				.orderBy(MATERIAL.CODE)
				.fetch()
				.stream()
				.limit(30)
				.map( new MaterialMapper(MATERIAL) )
				.collect(Collectors.toCollection(LinkedList::new));
	}
	public static Material save(DBContext ctx, Material material) {
		if (material.getId() == null) {
			return insert(ctx, material);
		} 
		return update(ctx, material);
	}
	public static Material insert(DBContext ctx,Material material) {
		Integer id = ctx.getDslContext()
			.insertInto(MATERIAL)
			.set(MATERIAL.DOMAIN,material.getDomain())
			.set(MATERIAL.CODE,material.getCode())
			.set(MATERIAL.NAME,material.getName())
			.set(MATERIAL.RAW_MATERIAL,material.getRawMaterial())
			.set(MATERIAL.RAW_COMPOSITION,material.getRawComposition())
			.set(MATERIAL.THICKNESS,material.getThickness())
			.set(MATERIAL.CREATION_USER,ctx.getUser())
			.set(MATERIAL.CREATION_DATE, new Timestamp( System.currentTimeMillis()) )
			.returning(MATERIAL.ID)
			.fetchOne()
			.getValue(MATERIAL.ID);
		ctx.log().info("INSERT MATERIAL: (id) " + id);		
		return getMaterial(ctx, id);
	}
	public static Material update(DBContext ctx, Material material) {
		int count = ctx.getDslContext()
			.update(MATERIAL)
			.set(MATERIAL.CODE,material.getCode())
			.set(MATERIAL.NAME,material.getName())
			.set(MATERIAL.RAW_MATERIAL,material.getRawMaterial())
			.set(MATERIAL.RAW_COMPOSITION,material.getRawComposition())
			.set(MATERIAL.THICKNESS,material.getThickness())
			.set(MATERIAL.MODIFICATION_USER,ctx.getUser())
			.set(MATERIAL.MODIFICATION_DATE, new Timestamp( System.currentTimeMillis()) )
			.where(MATERIAL.ID.equal( material.getId()))
			.execute();
		ctx.log().info("UPDATE MATERIAL ("+count+" filas) : (id) " + material.getId());		
		return getMaterial(ctx, material.getId());
	}
	public static void delete(DBContext ctx, Material material) {
		int count = ctx.getDslContext()
				.delete(MATERIAL)
				.where(MATERIAL.ID.equal( material.getId()))
				.execute();
			ctx.log().info("DELETE MATERIAL ("+count+" filas) : (id) " + material.getId());		
	}

}
