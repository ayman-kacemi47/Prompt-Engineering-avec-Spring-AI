package net.kacemi.springai.outputs;

public record CIN(
        String numeroCNI,             // Exemple : AB123456
        String nom,                   // Nom de famille
        String prenom,                // Prénom(s)
        String nomArabe,              // Nom en arabe
        String prenomArabe,           // Prénom(s) en arabe
        String sexe,                  // "Homme" ou "Femme"
        String nationalite,           // "Marocaine"
        String lieuNaissance,         // Lieu de naissance (français)
        String lieuNaissanceArabe,    // Lieu de naissance (arabe)
        String dateNaissance,         // Format : yyyy-MM-dd
        String adresse,               // Adresse complète (français)
        String adresseArabe,          // Adresse complète (arabe)
        String dateDelivrance,        // Format : yyyy-MM-dd
        String dateExpiration,        // Format : yyyy-MM-dd
        String autoriteDelivrance     // Exemple : Wilaya de Casablanca
) {
}
