package ch.heigvd.diary;

/**
 * Enregistrer les informations d'un rendez-vous d'agenda.
 * 
 * @author David J. Barnes et Michael Kolling
 * @version 2008.03.30
 */
public class Appointment
{
    // La raison du rendez-vous.
    private String description;
    // La durée (en heures) du rendez-vous.
    private int duration;

    /**
     * Crée un rendez-vous de la durée donnée.
     * @param description La raison de ce rendez-vous.
     * @param duration La durée de ce rendez-vous en heures.
     */
    public Appointment(String description, int duration)
    {
        this.description = description;
        this.duration = duration;
    }

    /**
     * @return La description du rendez-vous.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * @return La durée (en heures) du rendez-vous.
     */
    public int getDuration()
    {
        return duration;
    }
}
