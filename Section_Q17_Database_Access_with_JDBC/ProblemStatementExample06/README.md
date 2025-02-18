# Problem Statement Example 06

**Instructions**: 
- Create `Transactions` with Statement;
- Use API:
	- `setAutoCommit(false)`, `commit()` and `rollback()`.

### SQL Statement:

```sql
conn = DB.getConnection();
conn.setAutoCommit(false);
st = conn.createStatement();
int rows01 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
int rows02 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
conn.commit();

catch (SQLException e) {
	try {
		conn.rollback();
		throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
} catch (SQLException ex) {
		throw new DbException("Error trying to rollback! Caused by: " + ex.getMessage());
}

```
### Database Preliminary:
![Database Preliminary](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_Q17_Database_Access_with_JDBC/ProblemStatementExample06/database-preliminary.png)

### Database Result:
![Database Result](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_Q17_Database_Access_with_JDBC/ProblemStatementExample06/database-result.png)

### Output Example:
```txt
rows01 = 2
rows02 = 2
```