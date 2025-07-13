package net.kacemi.springai.outputs;

import java.time.LocalDate;

public record SchengenVisa(
        String visaNumber,          // Numéro du visa (ex: 123456789)
        String type,                // Type de visa (ex: "C", "D", "A")
        String firstName,           // Prénom
        String lastName,            // Nom
        String fullNameArabic,      // Nom complet en arabe (si disponible)
        LocalDate birthDate,        // Date de naissance
        String birthPlace,          // Lieu de naissance
        String nationality,         // Nationalité
        String passportNumber,      // Numéro du passeport
        String issuingCountry,      // Pays émetteur
        LocalDate issueDate,        // Date de délivrance du visa
        LocalDate validFrom,        // Début de validité du visa
        LocalDate validUntil,       // Fin de validité du visa
        int numberOfEntries,        // Nombre d’entrées autorisées (ex: 1, 2, "MULT")
        int durationOfStay,         // Durée autorisée (en jours)
        String issuedIn,            // Ville ou pays de délivrance
        String visaStickerNumber,   // Numéro sur l’étiquette/sticker
        String remarks              // Remarques diverses ou mentions spéciales
) {
}
