package com.merkapack.erp.core.dao;

import java.util.LinkedList;

import com.merkapack.erp.core.basic.DBContext;
import com.merkapack.erp.core.dao.jooq.ClientDAO;
import com.merkapack.erp.core.dao.jooq.MachineDAO;
import com.merkapack.erp.core.dao.jooq.MaterialDAO;
import com.merkapack.erp.core.dao.jooq.ProductDAO;
import com.merkapack.erp.core.model.Client;
import com.merkapack.erp.core.model.Machine;
import com.merkapack.erp.core.model.Material;
import com.merkapack.erp.core.model.Product;

public class MkpkGo {
	
	//							--------
	// 							[CLIENT]
	//							--------
	public static LinkedList<Client> getClients(DBContext ctx) {
		return ctx.getDslContext().transactionResult(
				configuration -> ClientDAO.getClients(ctx));
	}
	
	public static LinkedList<Client> getClients(String query, DBContext ctx) {
		return ctx.getDslContext().transactionResult(
				configuration -> ClientDAO.getClients(ctx,query));
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
	
	public static LinkedList<Material> getMaterials(String query, DBContext ctx) {
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
	public static LinkedList<Product> getProducts(DBContext ctx) {
		return ctx.getDslContext().transactionResult(
				configuration -> ProductDAO.getProducts(ctx));
	}
	
	public static LinkedList<Product> getProducts(DBContext ctx,String query) {
		return ctx.getDslContext().transactionResult(
				configuration -> ProductDAO.getProducts(ctx,query));
	}

	public static Product save(DBContext ctx,Product product) {
		return ctx.getDslContext().transactionResult(
				configuration -> ProductDAO.save(ctx,product));
	}

	public static void delete(DBContext ctx, Product product) {
		ctx.getDslContext().transaction( configuration -> ProductDAO.delete(ctx,product));
	}

}
