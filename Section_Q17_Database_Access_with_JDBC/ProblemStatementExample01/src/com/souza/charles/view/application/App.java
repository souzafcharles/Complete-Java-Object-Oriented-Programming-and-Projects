package com.souza.charles.view.application;

import java.sql.Connection;

import com.souza.charles.model.db.DB;

public class App {
	public static void main(String[] args) {
		Connection conn = DB.getConnection();
		DB.closeConnection();
	}
}