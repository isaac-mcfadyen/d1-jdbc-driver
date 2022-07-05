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

Installation instructions:
1. Download the latest release of the D1 JDBC Driver from [here](https://github.com/isaac-mcfadyen/d1-jdbc-driver/releases).  
2. Move the .jar file to somewhere on your computer where you can store it permanently.  
3. Open Datagrip (or another Jetbrains tool) and add a new Database Driver. (Figure 1)
4. Name it D1 JDBC Driver. Click on the plus sign beside Driver Files, select Custom JARs, then navigate to and choose the downloaded .jar file. 
5. Select `org.isaacmcfadyen.D1Driver` from the dropdown. (Figure 2)
6. Go to the Options tab, scroll down to the bottom, and change the Dialect to SQLite. *This is required for proper auto-complete functionality.*  (Figure 3)
7. Go to the Data Sources panel, add a new Data Source, and select D1 JDBC Driver as the source. (Figure 4)
8. Enter the URL, in the format `jdbc:d1://<UUID>` where `<UUID>` is the ID of the D1 database you were given at creation. For the User field, enter your Cloudflare Account ID, and for the Password field enter an [API Token](https://dash.cloudflare.com/?to=/profile/api-tokens) with the D1 Edit scope. (Figure 5)
9. Hit Test Connection. If all is good, you should see a green message saying that the connection succeeded! If it failed, try going back through these steps and making sure you didn't make a typo. If you need help, join us on the [Cloudflare Developers
Discord](https://discord.gg/cloudflaredev). (Figure 6)

Figure 1:  
<img width="224" alt="Figure 1" src="https://user-images.githubusercontent.com/6243993/177220616-a1c0555c-e54e-475d-b667-c0a9b327ce78.png">

Figure 2:  
<img width="803" alt="Selecting Driver Class" src="https://user-images.githubusercontent.com/6243993/177220676-ba7b3598-d79e-4178-a495-cf2680c7c6e9.png">

Figure 3:  
<img width="799" alt="Selecting Dialect" src="https://user-images.githubusercontent.com/6243993/177220738-1a1b277a-8d91-470c-ad6c-b61c59b786fb.png">

Figure 4:  
<img width="286" alt="Selecting Data Source" src="https://user-images.githubusercontent.com/6243993/177220780-c28e6f56-b4b5-47ad-a3d1-0d113e5f1830.png">

Figure 5:  
<img width="798" alt="Example of Authentication" src="https://user-images.githubusercontent.com/6243993/177220872-78a4b7a3-568b-4926-a544-63d10ee631a9.png">

Figure 6:  
<img width="362" alt="Connection Succeeded" src="https://user-images.githubusercontent.com/6243993/177220909-ec0250fa-4dc2-4abf-a27a-37aff8592c5c.png">


