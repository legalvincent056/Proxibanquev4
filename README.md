# ProxiBanqueV4 - Vincent Le Gal - Théo Villar - Florent Marin -Florent Ayraud
Comment lancer l'application Java ProxiBanqueV4

Remarque : les messages d'erreurs ne sont pas tous implémentés (modification client par exemple).
Egalement, la mise en page via PrimeFace n'est pas trés finie. Le Rapport sur les transactions n'a egalement pas pu 
etre implémentés. Ainsi que le tracage des operation sensible par AOP et la mise en place d'un service REST.
Le projet a été realisé en Maven MonoModule.

## Pré-requis:
	- Machine cible dotée d'un systeme d'exploitation Windows.
		
	- Installer un serveur d'application Tomcat 9 sur la machine cible et s'assurer qu'il est lancé.

	(Téléchargé depuis : http://tomcat.apache.org/download-90.cgi)
			
	- Installer un serveur de base de donnée mySQL sur la machine cible et s'assurer qu'il est lancé.
		
	(Par exemple WAMPserver permet d'en installer un, il est téléchargeable depuis http://www.wampserver.com/)
			
	- Créer une base de donnée nommée : "proxiv3", définir son encodage "utf8_general_ci".
		
	(En utilisant par exemple phpMyAdmin fournit dans WAMPserver)
## Execution :
	- Créer et peupler les tables de la base de donnée en exécutant le fichier "SQL\proxiv3.sql"
		
	(dans phpMyAdmin en cliquant sur l'onglet import)
			
	- Copier le fichier "livraison\configJSFSpringData.war" dans le repertoire "webapps" de Tomcat
		
	(ex: C:\apache-tomcat-9.0.0.M19\webapps, si Tomcat est installé dans C:\apache-tomcat-9.0.0.M19)
			
	- Accéder à l'application par un navigateur via l'url suivante "http://localhost:8080/configJSFSpringData/"
		
	(le port 8080 dépend de votre configuration Tomcat)
	
	Connexion comme Gérant:
		fenêtre de connexion:
			login: demo3
			mot de passe: demo3
			
				
	Connexion comme Conseiller:
	
		Fenêtre de connexion:
	
			- Par défaut il y'a deux conseillers dans la base
				login : demo
				mot de passe : demo
		
				login : demo2
				mot de passe : demo2

## Consulter la documentation: 
	- Double-cliquer sur le fichier index.html se trouvant dans le repertoire "doc" livré avec le fichier war.
