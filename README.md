## Version Compatibility

```
Neo4j Server 3.x – Java 8
Neo4j Server 4.x – Java 11
```

## Neo4j installation


<details><summary>Ubuntu</summary>

<p>

```
wget -O - https://debian.neo4j.com/neotechnology.gpg.key | sudo apt-key add -
echo 'deb https://debian.neo4j.com stable latest' | sudo tee -a /etc/apt/sources.list.d/neo4j.list
sudo apt-get update
```
- List all versions of neo4j

```
apt list -a neo4j
```
- Install neo4j with your choice of version
```
sudo apt-get install neo4j=<version>
```
- Restart, start, status odf service

```
sudo service neo4j start
sudo service neo4j status
sudo service neo4j restart
sudo service neo4j stop
```
</p>
</details>