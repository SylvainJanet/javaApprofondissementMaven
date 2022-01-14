package o11.maven;

public class App11 {

	public static void main(String[] args) {
		/*
		 * 
		 * Maven est un outil de build qui permet d'automatiser la gestion
		 * et la construction d'un projet Java
		 * 
		 * On peut l'utiliser en ligne de commande mais il est également intégré
		 * nativement dans les IDE.
		 * 
		 * Permet d'automatiser : 
		 * - la création d'un projet avec une structure de dossier commune avec 
		 * tous les projets Maven
		 * - le lancement des tests
		 * - le déploiement du projet
		 * 
		 * Permet aussi de gérer les dépendances du projet
		 * 
		 * Pour l'instant, une dépendance est rajoutée à la main et dépend de la structure
		 * de fichiers de notre machine.
		 * - soucis lorsque on doit rajouter plusieurs dépendances, qui elle même dépendent de plusieurs .jar,
		 * on a beaucoup de dépendance à rajouter
		 * - lors du partage de notre projet, si les dépendances ne sont pas stockées au même
		 * endroit dans la machine de nos collègues, ça va poser problème
		 * 
		 * La seule chose à configurer lors de la création d'un projet est fichier 
		 * pom.xml un fichier de configuration
		 * 
		 * File -> New -> Maven Project
		 * skip archetype selection
		 * créé mon projet simple
		 * Modifier le build path et le compilateur pour les mettre à la bonne version du jdk
		 * clic droit JRE system library -> properties -> mettre le bon jdk
		 * clic droit projet -> properties -> Java compiler -> compliance level 1.8
		 * 
		 * 
		 * Les projets Maven ont une structure bien définie.
		 * src/main/java : contient toutes les classes Java de notre programme
		 * src/main/resources : contient toutes les ressources utilisées dans notre programme : images, 
		 * fichiers texte, fichiers de configuration, ...
		 * src/test/java : contient toutes les classes de test
		 * src/test/resourcres : contient toutes les ressources utilisées pour les tests
		 * target : contenir tous les fichiers qui vont être généré par maven lors des différents traitements
		 * de maven
		 * pom.xml : la configuration de notre projet
		 * 
		 * 
		 * Principe - décomposition en phases et goals
		 * 
		 * Maven découpe le cycle de construction d'un projet en plusieurs phases
		 * L'idée : Préparer les fichiers, tester le projet, et si ils réussissent, compiler le projet
		 * 
		 * Les principales phases dans Maven :
		 * compile : compiler le code source
		 * test : lancer les tests du projet
		 * package : compiler
		 * clean : nettoyer les projets
		 * validate : valider le pom d'un projet
		 * deploy : deployer le projet compilé quelque part
		 * 
		 * Chaque phase est elle même décomposée en série de goals.
		 * 
		 * 
		 * Principe - dépendances
		 * 
		 * Maven va nous permettre de gérer les dépendances.
		 * Au lieu d'avoir besoin de télécharger nous même les .jar et les ajouter à la main à notre
		 * projet, on va rajouter la dépendance de le pom.xml de notre projet
		 * et Maven se charge de les télécharger depuis un repo centraliser (le dépôt central de maven)
		 * 
		 * Dépot local Maven : emplacement sur votre machine où est stocké un ensemble de dépendances.
		 * Par défaut il se situe dans le dossier .m2 
		 * C:\Users\UTILISATEUR\.m2
		 * 
		 * Dépot central de Maven : emplacement distant depuis lequel toutes les dépendances
		 * vont être téléchargées
		 * 
		 * Pour gérer les dépendances (et la configuration maven du projet), on va utiliser le fichier pom.xml
		 * Tous les POM héritent d'un super POM (qui contient des informations sur le référentiel central)
		 * https://maven.apache.org/ref/3.0.4/maven-model-builder/super-pom.html
		 * 
		 * On peut voir dans l'editeur le POM final tel qu'il est utilisé par Maven en regardant "effective POM"
		 * 
		 * Un fichier XSD (XML Schema Document) permet de garantir la cohérence
		 * et la validité des informations contenues dans un fichier XML.
		 * L'architecture du pom.xml est normalisée par un XSD fourni par maven
		 * 
		 * Le sens des balises :
		 * project : l'élément racine du pom.xml
		 * modelVersion : version du POM qu'on utilise
		 * groupId : un identifiant du groupe du projet. Ca ressemble à un nom de package.
		 * Par exemple, pour hibernate : org.hibernate
		 * artifactId : un identifiant du projet, permet de fournir le nom du projet dans le groupe de projet
		 * donné par le groupId
		 * Par exemple, pour une des dépendances hibernate : hibernate-core
		 * 
		 * Un artifact est un projet type. Maven en propose plusieurs : 
		 * maven-archetype-simple
		 * maven-archetype-quickstart
		 * ...
		 * 
		 * version : un numéro de version du projet
		 * principe : une version publiée ne va jamais être modifiée. Si il y a des modifications,
		 * elles seront implémentées dans une autre version
		 * SAUF si le numéro de version se termine par .SNAPSHOT
		 * 
		 * packaging : le format pris par l'artifact lors de la compilation
		 * (JAR, WAR, ... )
		 * 
		 * Si vous avez besoin des informations sur une dépendances (groupId, artifactId, ...)
		 * vous pouvez les trouver sur le repository maven
		 * https://mvnrepository.com/
		 * 
		 * 
		 * Pour faire un projet constitué de plusieurs modules :
		 * Le module parent : créer un Maven Project de type simple, avec packaging pom
		 * 
		 * 
		 * Plus d'informations : 
		 * 
		 * - Cycle de vie d'un projet : 
		 * 
		 * 		La succession de phases exécutant chacune un ou plusieurs goals est définie comme un cycle de vie du projet.
		 * 		Exemple de cycle de vie d’un projet JAR qui comprend 8 phases :
		 * 		- process-resources : copie les fichiers (fichiers de propriétés...), hors code source, dans
		 * 		le répertoire de construction finale en les filtrant si nécessaire.
		 * 		- compile : compile le code source du projet dans le dossier de construction du JAR.
		 * 		- process-test-resources : Phase;process-test-resources copie les fichiers de test, hors
		 * 		code source, dans le dossier de compilation des tests.
		 * 		- test-compile : compile les fichiers code source des tests dans le dossier de sortie des
		 * 		tests.
		 * 		- test : exécute les tests unitaires.
		 * 		- package : crée l’archive JAR à partir du dossier contenant les sources compilées et les
		 * 		fichiers de ressources filtrés.
		 * 		- install : copie de l’archive JAR dans le référentiel local défini dans la configuration
		 * 		Apache Maven (pom.xml, settings.xml).
		 *		 - deploy : déploie l’archive JAR dans le référentiel distant défini dans la configuration
		 * 		Apache Maven (settings.xml, pom.xml). 
		 * 
		 * 		https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#Lifecycle_Reference
		 * 
		 * - Propriétés dans le pom.xml :
		 * 		Possibilité d'utiliser d'autre propriétés (variables d'environnements, propriétés liés au projet 
		 * 		comme le répertoire de base, ou encore des propriétés du settings.xml) 
		 * 		https://maven.apache.org/pom.html#Properties
		 * 
		 * 
		 * 
		 * 
		 * Parties skippées à rattraper : 
		 * - Le fichier setting.xml
		 * 
		 * 		Le fichier settings.xml est le fichier configuration globale de tous les projets Maven.
		 * 		Il existe en réalité deux fichiers settings.xml :
		 * 		- Le fichier local spécifique à l’utilisateur présent dans ${user.home}/.m2/ settings.xml.
		 * 		- Le fichier global à l’installation présent dans MAVEN_HOME/conf/settings.xml.
		 * 
		 * 		Les informations présentes dans les deux fichiers XML sont fusionnées pour créer un 
		 * 		unique fichier settings.xml. Les informations peuvent également être surchargées, 
		 * 		puisque ce sont les données du fichier local qui prédominent sur celles du fichier global. 
		 * 
		 * - profils
		 * - portées de dépendances
		 * - Dépendances transitives, dépendance optionnelles
		 * - Gestion des versions (patterns)
		 * - Gestion des conflits
		 * - Enregistrer un projet/ une archive en tant que dépendance dans le repository
		 * - tout ce qui est en rapport avec l'intégration continue
		 * - Génération d'un site Maven (mvn site)
		 * - Rapports de tests (surfire)
		 * - Documentation technique (JavaDoc), sources (JXR)
		 * - Qualimétrie : Maven et Sonar
		 * 
		 * - problème lors de la création de projet maven-archetype-quickstart
		 * 		schéma XNS non valide chez quelques uns.
		 */
	}
}
