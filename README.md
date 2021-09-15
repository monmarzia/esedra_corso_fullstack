## Esedra corso full stack

Per compilare una classe spostarsi nella cartella src

```bash
javac -d ../bin it/esedra/corso/lezioni/Operatori.java
```

X Windows invece

```bash
javac -d ..\bin it\esedra\corso\lezioni\Operatori.java
```


Per eseguire spostarsi nella cartella bin e quindi

```bash
java it.esedra.corso.lezioni.Operatori
```


### Installazione di Github
Scaricare ed installare la versione di github per il proprio sistema operativo.

Per Windows 10 scarichiamo

https://git-scm.com/downloads

Installare la versione di default e modificare soltanto "Choosing the default editor used by Git" selezionando Notepad

### Installazione di Eclipse

https://www.eclipse.org/downloads/packages/

Scarichiamo ed installiamo la versione "Eclipse IDE for Enterprise Java and Web Developers" scompattando il contenuto in una cartella.
Lanciare quindi il file eseguibile eclipse dentro la cartella.

Una volta avviato Eclipse chiede un percorso per generare la cartella del workspace: [WORKSPACE_FOLDER]

Cliccando

### Configurazione del progetto

Tramite promp dei comandi andare su [WORKSPACE_FOLDER] e quindi digitare

```bash
git clone https://github.com/andreadotta/esedra_corso_fullstack.git
```
Creerà una cartella esedra_corso_fullstack dentro [WORKSPACE_FOLDER]

Su Eclipse si va su 
File->New->Java Project 
e quindi come "Project name" si scrive esedra_corso_fullstack.
Cliccare su "Finish", confermare tutti i passaggi e quindi cliccare su "Open Java perspective"

#### Compilazione e build
Cliccando con il pulsante destro sulla cartella del progetto si seleziona Proprietà e quindi nella finestra che si apre si imposta:

- Java Build Path
       Su libraries verificare che: tra i modulepath sia presente la JRE System Library
       Nel class path deve essere presente il file javax.json.1.1.4.jr che si trova nella cartella lib (eventualmente si carica cliccando su add library a destra)
- Project Natures
        Deve essere presente Java, altrimenti aggiungere premenedo su Add a destra

### NODE e NPM
Nella cartella www eseguire il comando
```bash
npm install
```
[NPM JS](https://www.npmjs.com/) home page di npm js

poi per lanciare il server
```bash
node server.js 
```

per raggiungere il server 
http://localhost:3000
