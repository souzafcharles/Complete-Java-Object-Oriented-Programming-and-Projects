package com.souza.charles.model.dao.impl;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: January 13, 2025
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.souza.charles.model.dao.SellerDao;
import com.souza.charles.model.db.DB;
import com.souza.charles.model.db.DbException;
import com.souza.charles.model.entities.Department;
import com.souza.charles.model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection connection;

	public SellerDaoJDBC(Connection conn) {
		this.connection = conn;
	}

	@Override
	public void insert(Seller seller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller seller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
								"SELECT seller.*,department.Name as DepName " 
								+ "FROM seller INNER JOIN department "
								+ "ON seller.DepartmentId = department.Id " 
								+ "WHERE seller.Id = ?");

			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Department department = instantiateDepartment(resultSet);
				Seller seller = instatiateSeller(resultSet, department);
				return seller;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closePreparedStatement(preparedStatement);
			DB.closeStatement(preparedStatement);
			DB.closeResultSet(resultSet);
		}
	}

	private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
		Department department = new Department();
		department.setId(resultSet.getInt("DepartmentId"));
		department.setName(resultSet.getString("DepName"));
		return department;
	}

	private Seller instatiateSeller(ResultSet resultSet, Department department) throws SQLException {
		Seller seller = new Seller();
		seller.setId(resultSet.getInt("Id"));
		seller.setName(resultSet.getString("Name"));
		seller.setEmail(resultSet.getString("Email"));
		seller.setBirthDate(resultSet.getDate("BirthDate"));
		seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
		seller.setDepartment(department);
		return seller;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
								"SELECT seller.*, department.Name as DepName "
								+ "FROM seller " + "INNER JOIN department ON seller.DepartmentId = department.Id "
								+ "WHERE DepartmentId = ? " 
								+ "ORDER BY Name");

			preparedStatement.setInt(1, department.getId());
			resultSet = preparedStatement.executeQuery();

			List<Seller> sellerList = new ArrayList<>();
			Map<Integer, Department> mapDepartment = new HashMap<>();

			while (resultSet.next()) {
				Department depart = mapDepartment.get(resultSet.getInt("DepartmentId"));

				if (depart == null) {
					depart = instantiateDepartment(resultSet);
					mapDepartment.put(resultSet.getInt("DepartmentId"), depart);
				}

				Seller seller = instatiateSeller(resultSet, depart);
				sellerList.add(seller);
			}
			return sellerList;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closePreparedStatement(preparedStatement);
			DB.closeStatement(preparedStatement);
			DB.closeResultSet(resultSet);
		}
	}
}