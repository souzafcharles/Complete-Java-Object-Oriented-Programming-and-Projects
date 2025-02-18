# Problem Statement Example 03

**Instructions**: 
- Simple insertion with `PreparedStatement`;
- Insertion with Id retrieval.

### SQL PreparedStatement:

```sql
ps = conn.prepareStatement(
		"INSERT INTO seller "
		+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
		+ "VALUES " 
		+ "(?, ?, ?, ?, ?)", 
		Statement.RETURN_GENERATED_KEYS);
			
	ps.setString(1, "Zuleica Serafina");
	ps.setString(2, "zuleica@emil.com");
	ps.setDate(3, new Date(sdf.parse("10/02/1985").getTime()));
	ps.setDouble(4, 3000.0);
	ps.setInt(5, 4);
```

### Database Result:
![Database Result](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_Q17_Database_Access_with_JDBC/ProblemStatementExample03/database-result.png)

### Output Example:
```txt
Done! Id: 7
```