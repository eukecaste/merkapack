package com.merkapack.erp.core.dao;

import java.util.LinkedList;

import com.merkapack.erp.core.basic.DBContext;
import com.merkapack.erp.core.dao.jooq.ClientDAO;
import com.merkapack.erp.core.dao.jooq.MachineDAO;
import com.merkapack.erp.core.dao.jooq.MaterialDAO;
import com.merkapack.erp.core.dao.jooq.PlanningDAO;
import com.merkapack.erp.core.dao.jooq.ProductDAO;
import com.merkapack.erp.core.dao.jooq.RollDAO;
import com.merkapack.erp.core.model.Client;
import com.merkapack.erp.core.model.Filter.ClientFilter;
import com.merkapack.erp.core.model.Filter.PlanningFilter;
import com.merkapack.erp.core.model.Filter.ProductFilter;
import com.merkapack.erp.core.model.Filter.RollFilter;
import com.merkapack.erp.core.model.Machine;
import com.merkapack.erp.core.model.Material;
import com.merkapack.erp.core.model.Planning;
import com.merkapack.erp.core.model.Product;
import com.merkapack.erp.core.model.Roll;
import com.merkapack.watson.util.MkpkStringUtils;

public class MkpkGo {
	
	//							--------
	// 							[CLIENT]
	//							--------
	public static LinkedList<Client> getClients(DBContext ctx) {
		return ctx.getDslContext().transactionResult(
				configuration -> ClientDAO.getClients(ctx));
	}
	
	public static LinkedList<Client> getClients(DBContext ctx, String query) {
		return ctx.getDslContext().transactionResult(
				configuration -> ClientDAO.getClients(ctx,query));
	}
	
	public static LinkedList<Client> getClients(DBContext ctx, ClientFilter filter) {
		return ctx.getDslContext().transactionResult(
				configuration -> ClientDAO.getClients(ctx,filter));
	}

	public static Client save(DBContext ctx,Client client) {
		return ctx.getDslContext().transactionResult(
				configuration -> ClientDAO.save(ctx,client));
	}

	public static void delete(DBContext ctx, Client client) {
		ctx.getDslContext().transaction( configuration -> ClientDAO.delete(ctx,client));
	}
	
	//							---------
	// 							[MACHINE]
	//							---------
	public static LinkedList<Machine> getMachines(DBContext ctx) {
		return ctx.getDslContext().transactionResult(
				configuration -> MachineDAO.getMachines(ctx));
	}
	
	public static LinkedList<Machine> getMachines(DBContext ctx,String query) {
		return ctx.getDslContext().transactionResult(
				configuration -> MachineDAO.getMachines(ctx,query));
	}

	public static Machine save(DBContext ctx,Machine machine) {
		return ctx.getDslContext().transactionResult(
				configuration -> MachineDAO.save(ctx,machine));
	}

	public static void delete(DBContext ctx, Machine machine) {
		ctx.getDslContext().transaction( configuration -> MachineDAO.delete(ctx,machine));
	}

	//							----------
	// 							[MATERIAL]
	//							----------
	public static LinkedList<Material> getMaterials(DBContext ctx) {
		return ctx.getDslContext().transactionResult(
				configuration -> MaterialDAO.getMaterials(ctx));
	}
	
	public static LinkedList<Material> getMaterials(DBContext ctx,String query) {
		return ctx.getDslContext().transactionResult(
				configuration -> MaterialDAO.getMaterials(ctx,query));
	}

	public static Material save(DBContext ctx,Material material) {
		return ctx.getDslContext().transactionResult(
				configuration -> MaterialDAO.save(ctx,material));
	}

	public static void delete(DBContext ctx, Material material) {
		ctx.getDslContext().transaction( configuration -> MaterialDAO.delete(ctx,material));
	}

	//							---------
	// 							[PRODUCT]
	//							---------
	public static LinkedList<Product> getProducts(DBContext ctx, int offset, int count, ProductFilter filter) {
		return ctx.getDslContext().transactionResult(
				configuration -> ProductDAO.getProductList(ctx, offset,count, filter));
	}
	public static LinkedList<Product> getProducts(DBContext ctx, int offset, int count,String query) {
		query = MkpkStringUtils.prependIfMissing(query, "%");
		final String qry = MkpkStringUtils.appendIfMissing(query, "%");
		return ctx.getDslContext().transactionResult(
				configuration -> ProductDAO.getProductList(ctx,offset,count,
						p -> p.getCodeProperty().like(qry)
						 .or(p.getNameProperty().like(qry)))
				);
	}

	public static Product save(DBContext ctx,Product product) {
		return ctx.getDslContext().transactionResult(
				configuration -> ProductDAO.save(ctx,product));
	}

	public static void delete(DBContext ctx, Product product) {
		ctx.getDslContext().transaction( configuration -> ProductDAO.delete(ctx,product));
	}

	//							------
	// 							[ROLL]
	//							------
	public static LinkedList<Roll> getRolls(DBContext ctx) {
		return ctx.getDslContext().transactionResult(
				configuration -> RollDAO.getRolls(ctx));
	}
	
	public static LinkedList<Roll> getRolls(DBContext ctx,String query, Integer material) {
		return ctx.getDslContext().transactionResult(
				configuration -> RollDAO.getRolls(ctx,query,material));
	}

	public static LinkedList<Roll> getRolls(DBContext ctx, RollFilter filter) {
		return ctx.getDslContext().transactionResult(
				configuration -> RollDAO.getRolls(ctx,filter));
	}

	public static Roll save(DBContext ctx,Roll roll) {
		return ctx.getDslContext().transactionResult(
				configuration -> RollDAO.save(ctx,roll));
	}

	public static void delete(DBContext ctx, Roll roll) {
		ctx.getDslContext().transaction( configuration -> RollDAO.delete(ctx,roll));
	}

	//							----------
	// 							[PLANNING]
	//							----------
	public static LinkedList<Planning> getPlannings(DBContext ctx, PlanningFilter filter) {
		return ctx.getDslContext().transactionResult(
				configuration -> PlanningDAO.getPlannings(ctx,filter));
	}
	
	public static Planning save(DBContext ctx,Planning planning) {
		return ctx.getDslContext().transactionResult(
				configuration -> PlanningDAO.save(ctx,planning));
	}

	public static LinkedList<Planning> save(DBContext ctx,LinkedList<Planning> list) {
		return ctx.getDslContext().transactionResult(
				configuration -> PlanningDAO.save(ctx,list));
	}

	public static void delete(DBContext ctx, Planning planning) {
		ctx.getDslContext().transaction( configuration -> PlanningDAO.delete(ctx,planning));
	}
}
