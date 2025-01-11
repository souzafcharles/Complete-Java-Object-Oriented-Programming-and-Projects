# Problem Statement Example 05

**Instructions**: 
- `Delete` item with `PreparedStatement`;
- Update informing how many lines have been changed;
- Create `DbIntegrityException`;
- Handle the referential integrity exception.

### SQL PreparedStatement:

```sql
ps = conn.prepareStatement(
		"DELETE FROM department "
		+ "WHERE "
		+ "Id = ?");

	ps.setInt(1, 5);
```
### Database Preliminary:
![Database Preliminary](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_Q17_Database_Access_with_JDBC/ProblemStatementExample05/database-preliminary.png)

### Database Result:
![Database Result](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_Q17_Database_Access_with_JDBC/ProblemStatementExample05/database-result.png)

### Output Example:
```txt
Done! Row(s) affected: 1
```