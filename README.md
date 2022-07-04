# D1 JDBC Driver

**A JDBC driver for [Cloudflare's D1 Database](https://blog.cloudflare.com/introducing-d1/) product!**

JDBC is the technology that drives popular database tools such as Jetbrains' database functionality integrated into their editors and [Datagrip](https://www.jetbrains.com/datagrip/), their standalone DB editor.

These tools all require a JDBC driver, an adapter that interfaces between the GUI and the Database.

The D1 JDBC Driver interfaces between these IDEs and Cloudflare's D1, and provides:
- 🔍 Powerful and automatic schema introspection capabilities
- ✍️ SQL statement execution, along with auto-formatted results
- 🔠 Support for all of the Datatype Affinities that SQLite supports (NUMERIC, TEXT, etc)

Known issues:
- Editing data directly via the table-like interface is not supported. *Editing data via SQL is still supported.*
- Foreign keys are not currently shown in the introspection window, although they are still there and working as normal.

For more info and to get help, join us on the [Cloudflare Developers
Discord](https://discord.gg/cloudflaredev)!