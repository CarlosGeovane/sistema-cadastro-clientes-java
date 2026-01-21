# 🚀 Sistema de Gestão de Clientes (Java Desktop)

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![macOS](https://img.shields.io/badge/macOS-000000?style=for-the-badge&logo=apple&logoColor=white)

Projeto desenvolvido para consolidar conceitos de **Arquitetura de Software**, persistência de dados e interfaces gráficas modernas. O sistema evoluiu de um console simples para uma aplicação desktop robusta com integração **MySQL**.

---

### ✨ Funcionalidades Principais

* **🎨 Interface Gráfica (GUI):** Experiência de usuário moderna utilizando **Swing** e o tema **FlatLaf (macOS Dark)**.
* **💾 Persistência Real:** Armazenamento em banco de dados **MySQL**, garantindo integridade dos dados.
* **🏗️ Padrão DAO:** Separação clara entre lógica de negócio e acesso a dados.
* **✅ Validação de Dados:** Filtros para garantir que campos obrigatórios sejam preenchidos corretamente.
* **📊 Listagem Dinâmica:** Tabela interativa (JTable) com atualização em tempo real.

---

### 🛠️ Tecnologias e Ferramentas

| Categoria | Tecnologia |
| :--- | :--- |
| **Linguagem** | Java 17+ (OpenJDK) |
| **Banco de Dados** | MySQL 9.5 (Homebrew) |
| **Interface** | Java Swing + FlatLaf (UI Premium) |
| **Gestão** | Maven |
| **Arquitetura** | Camadas (Model, DAO, Service, GUI) |

---

### 📂 Estrutura do Projeto

* `model/`: Entidade `Cliente` representando o objeto de negócio.
* `dao/`: `ClienteDAO` – Responsável pelos comandos SQL (Insert, Select).
* `service/`: `ClienteService` – Camada intermediária com regras e validações.
* `factory/`: `ConnectionFactory` – Gerenciamento da conexão JDBC.
* `app/`: `ClienteGUI` – Interface visual principal.

---

### 🚀 Como Executar

**1. Pré-requisitos:**
* Java JDK 17 ou superior.
* MySQL rodando localmente (porta 3306).

**2. Script de Banco:**
```sql
CREATE DATABASE sistema_clientes;
USE sistema_clientes;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(20)
);
