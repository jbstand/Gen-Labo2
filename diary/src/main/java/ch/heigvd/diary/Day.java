package ch.heigvd.diary;

/**
 * Maintient les rendez-vous pour une journée dans un agenda.
 * 
 * @author David J. Barnes et Michael Kolling
 * @version 2008.03.30
 */
public class Day
{
    // La première et la dernière heure réservable dans une journée.
    public static final int START_OF_DAY = 9;
    public static final int FINAL_APPOINTMENT_TIME = 17;
    // Le nombre d'heures qui peuvent être réservées dans une journée.
    public static final int MAX_APPOINTMENTS_PER_DAY =
                                FINAL_APPOINTMENT_TIME -
                                START_OF_DAY + 1;
    
    // Un numéro de journée dans une année particulière (1-366)
    private int dayNumber;
    // La liste courante des rendez-vous pour cette journée.
    private Appointment[] appointments;
    /**
     * Constructeur pour les objets de la classe Day.
     * @param dayNumber Le numéro de cette journée dans l'année (1-366).
     */
    public Day(int dayNumber)
    {
        this.dayNumber = dayNumber;
        appointments = new Appointment[MAX_APPOINTMENTS_PER_DAY];
    }

    /**
     * Recherche d'une place libre pour un rendez-vous.
     * @param appointment Le rendez-vous à traiter.
     * @return La première heure disponible dans la journée 
     *         pour le rendez-vous. Renvoie -1 s'il n'y a 
     *         de place disponible.
     */ 
    public int findSpace(Appointment appointment) throws NoSpaceException {
        int duration = appointment.getDuration();
        for(int slot = 0; slot < MAX_APPOINTMENTS_PER_DAY; slot++) {
            if(appointments[slot] == null) {
                final int time = START_OF_DAY + slot;
                // Point de départ potentiel.
                if(duration == 1) {
                    // un seul créneau est nécessaire.
                    return time;
                }
                else {
                    // Combien de créneaux supplémentaires sont nécessaires ?
                    int further_slots_required = duration - 1;
                    for(int nextSlot = slot + 1;
                                further_slots_required > 0 &&
                                appointments[nextSlot] == null;
                                    nextSlot++) {
                        further_slots_required--;
                    }
                    if(further_slots_required == 0) {
                        // Un espace suffisamment grand a été trouvé.
                        return time;
                    }
                }
            }
        }
        // Il n'y a pas assez de place disponible.
        throw new NoSpaceException(dayNumber);
    }

    /**
     * Prendre un rendez-vous.
     * @param time L'heure de début du rendez-vous.
     * @param appointment Le rendez-vous à prendre.
     * @return true si le rendez-vous a été pris, false sinon.
     */
    public boolean makeAppointment(int time,
                                   Appointment appointment)
    {
        if(validTime(time)) {
            int startTime = time - START_OF_DAY;
            if(appointments[startTime] == null) {
                int duration = appointment.getDuration();
                // Remplit tous les créneaux pour 
                // la durée totale du rendez-vous.
                for(int i = 0; i < duration; i++) {
                    appointments[startTime + i] = appointment;
                }
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    /**
     * @param time L'heure du jour. Doit être comprise entre l'heure
     *        START_OF_DAY et FINAL_APPOINTMENT_TIME.
     * @return Le rendez-vous au moment donné, null 
     *         si l'heure n'est pas valide ou s'il n'y a pas
     *         de rendez-vous à l'heure donnée.
     */
    public Appointment getAppointment(int time)
    {
        if(validTime(time)) {
            return appointments[time - START_OF_DAY];
        }
        else {
            return null;
        }
    }

    /**
     * Affiche une liste des rendez-vous de la journée sur la sortie standard.
     */
    public void showAppointments()
    {
        System.out.println("=== jour " + dayNumber + " ===");
        int time = START_OF_DAY;
        for(Appointment appointment : appointments) {
            System.out.print(time + ": ");
            if(appointment != null) {
                System.out.println(appointment.getDescription());
            }
            else {
                System.out.println();
            }
            time++;
        }
    }

    /**
     * @return Le numéro de cette journée dans l'année (1 - 366).
     */
    public int getDayNumber()
    {
        return dayNumber;
    }
    
    /**
     * @return true si l'heure est comprise entre FINAL_APPOINTMENT_TIME et
     *         END_OF_DAY, false autrement.
     */
    public boolean validTime(int time)
    {
        return time >= START_OF_DAY && time <= FINAL_APPOINTMENT_TIME;
    }
}
