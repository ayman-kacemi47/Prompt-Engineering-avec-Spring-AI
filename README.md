# 🤖 Spring AI & Prompt Engineering — ENSET Project

> 🌟 Projet réalisé dans le cadre du module **Generative AI and AI Agents** à l’**ENSET Mohammedia**, explorant les 3 techniques principales de **Prompt Engineering**, l’intégration de **GPT-4o (OpenAI)**, et les tests en local avec **Ollama 3.2**.

---

## 🎯 Objectifs pédagogiques

- Mettre en pratique les **3 types fondamentaux de Prompt Engineering** :
  1. **Zero-Shot Prompting**
  2. **Few-Shot Prompting**
  3. **Chain-of-Thought Prompting**

- Intégrer et tester des modèles IA via **Spring AI** :
  - 🔑 **GPT-4o** (API OpenAI)
  - 💻 **Modèle local via Ollama 3.2**

- Générer des images avec **DALL·E 3**
- Extraire des données à partir d'images avec des prompts multimodaux (image + texte)

---

## 🧪 Technologies utilisées

| Composant              | Description                                      |
|------------------------|--------------------------------------------------|
| Java 21                | Langage principal du backend                     |
| Spring Boot 3.5.3      | Framework backend                                |
| Spring AI              | Abstraction pour LLM et image generation         |
| OpenAI GPT-4o          | Modèle cloud utilisé via API Key                 |
| DALL·E 3               | Génération d’images HD                           |
| Ollama 3.2             | Serveur de modèles IA locaux                     |
| Swagger / OpenAPI 3    | Documentation automatique de l’API               |

---

## 🔁 Bascule entre GPT-4o (cloud) et Ollama (local)

Changement simple via `application.properties` :

```properties
# Pour OpenAI (cloud)
spring.ai.openai.api-key=sk-...
spring.ai.openai.chat.options.model=gpt-4o

# Pour Ollama (local)
# spring.ai.ollama.chat.model=llama3
💡 Permet de tester un même endpoint avec différents moteurs IA.
```
📦 API Endpoints disponibles
POST /multi-modal/cin-marocaine-ocr
Upload d’une image de CIN marocaine

Prompt texte + image envoyés à GPT-4o

Extraction structurée des informations (nom, prénom, etc.)

POST /multi-modal/schengen-visa-ocr
Upload d’une image de visa Schengen

Extraction des données : numéro, nom, type de visa, dates, etc.

GET /generate-image
Génération d’une image à partir d’un prompt

Utilise DALL·E 3 avec option quality=hd

GET /chat, /stream, /nostream, /askAgent
Tests de prompting (text only)

Adapté pour expérimenter :

Zero-shot

Few-shot

Chain-of-Thought

Utilisables avec GPT-4o ou un modèle local selon configuration

📘 Apprentissage et résultats
✅ J’ai appris à :

Structurer différents types de prompts (ZS, FS, CoT)

Exploiter les capacités multimodales d’un LLM (texte + image)

Générer des images avec DALL·E 3 dans une API Spring

Intégrer et basculer dynamiquement entre GPT-4o et Ollama

Construire une documentation OpenAPI automatiquement

🏫 Contexte académique
🎓 Formation : Master Ingénierie Informatique

🏫 Établissement : ENSET Mohammedia

📘 Module : Generative AI and AI Agents

📝 Travail pratique : Prompt Engineering avec Spring AI

📄 Exemple d'appel API

<img width="413" height="269" alt="Capture d'écran 2025-07-13 120735" src="https://github.com/user-attachments/assets/68eb0291-05e5-469c-a605-d9130b519f50" />

```bash
curl -X 'POST' \
  'http://localhost:8899/multi-modal/cin-marocaine-ocr?query=extract%20data' \
  -H 'accept: */*' \
  -H 'Content-Type: multipart/form-data' \
  -F 'file=@Capture d'\''écran 2025-07-13 120735.png;type=image/png'
```
```json
{
  "message": "",
  "data": {
    "numeroCNI": "U1234567",
    "nom": "EL ALAMI",
    "prenom": "ZAINEB",
    "nomArabe": "العلمي",
    "prenomArabe": "زينب",
    "sexe": "F",
    "nationalite": "Marocaine",
    "lieuNaissance": "OUARZAZATE",
    "lieuNaissanceArabe": "ورزازات",
    "dateNaissance": "05.12.1983",
    "adresse": "",
    "adresseArabe": "",
    "dateDelivrance": "",
    "dateExpiration": "22.07.2029",
    "autoriteDelivrance": "رئيس دائرة الشرطة"
  }
}
```

--------------------------------------------
prompt: A dramatic traditional Moroccan Fantasia (Tbourida) scene with powerful horses charging forward in unison, riders dressed in ornate white djellabas and colorful turbans, holding long traditional shotguns (moukahla) in the air, firing simultaneously. Dense fog and dust rise around them, with golden sunlight piercing through the mist. The background shows a rural Moroccan landscape with a cheering crowd blurred in the distance. High-detail, cinematic lighting, dynamic composition, culturally authentic, painted in a realistic fine art style.
```bash
curl -X 'GET' \
  'http://localhost:8899/generate-image?prompt=A%20dramatic%20traditional%20Moroccan%20Fantasia%20%28Tbourida%29%20scene%20with%20powerful%20horses%20charging%20forward%20in%20unison%2C%20riders%20dressed%20in%20ornate%20white%20djellabas%20and%20colorful%20turbans%2C%20holding%20long%20traditional%20shotguns%20%28moukahla%29%20in%20the%20air%2C%20firing%20simultaneously.%20Dense%20fog%20and%20dust%20rise%20around%20them%2C%20with%20golden%20sunlight%20piercing%20through%20the%20mist.%20The%20background%20shows%20a%20rural%20Moroccan%20landscape%20with%20a%20cheering%20crowd%20blurred%20in%20the%20distance.%20High-detail%2C%20cinematic%20lighting%2C%20dynamic%20composition%2C%20culturally%20authentic%2C%20painted%20in%20a%20realistic%20fine%20art%20style.' \
  -H 'accept: */*'
```
<img width="1024" height="1024" alt="img-L77OeamBXmp66UI4NuodznD8" src="https://github.com/user-attachments/assets/6975a786-843f-4e37-b583-21f9242116a1" />


👨‍💻 Auteur
Ayman Kacemi
🎓 Étudiant Master à l’ENSET Mohammedia
🐙 GitHub : ayman-kacemi47
🌐 Site perso : kacemi.net

📄 Licence
Ce projet est à but éducatif dans le cadre de la formation à l’ENSET.
