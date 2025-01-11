# Problem Statement Example 04

**Instructions**: 
- Simple insertion with `PreparedStatement`;
- `Update` informing how many rows have been changed.

### SQL PreparedStatement:

```sql
ps = conn.prepareStatement(
		"UPDATE seller " 
		+ "SET BaseSalary = BaseSalary 
		+ ? " 
		+ "WHERE " 
		+ "(DepartmentId = ?)");
	ps.setDouble(1, 200.0);
	ps.setInt(2, 2);
```
### Database Preliminary:
![Database Preliminary](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_Q17_Database_Access_with_JDBC/ProblemStatementExample04/database-preliminary.png)

### Database Result:
![Database Result](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_Q17_Database_Access_with_JDBC/ProblemStatementExample04/database-result.png)

### Output Example:
```txt
Done! Rows affected: 2
```