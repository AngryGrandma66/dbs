# DBS\_semestrálka

Krátké instrukce, jak projekt zkompilovat a spustit pomocí Maven a JavaFX.

## Požadavky

* Java 22 (JDK) nainstalované a nastavené proměnné `JAVA_HOME`.
* Maven (verze 3.8+).
* Připojení k PostgreSQL a odpovídající databáze `nemocnice`.

## Spuštění z příkazové řádky

### 1) `javafx:run` plugin (doporučeno)

1. Vyčistí předchozí build:

   ```bash
   mvn clean
   ```
2. Spustí aplikaci přes JavaFX plugin (zajistí zahrnutí FXML a modulů):

   ```bash
   mvn javafx:run
   ```

### 2) `exec:java` (alternativa)

Pokud `javafx:run` selže, lze spustit přímo hlavní třídu:

```bash
mvn clean compile exec:java
```

> **Poznámka:** Ujistěte se, že FXML jsou zahrnuté v `target/classes` — použijte `compile` nebo IntelliJ build.

## Vytvoření spustitelného JAR

1. Vytvoř balíček:

   ```bash
   mvn clean package
   ```
