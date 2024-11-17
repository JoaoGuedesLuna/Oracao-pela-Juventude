package main.java.dev.guedes.oracaopelajuventude.raffler;

import main.java.dev.guedes.oracaopelajuventude.renderer.Renderer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Randomizer class for selecting who will pray for whom in a prayer circle.
 * This class is responsible for randomly assigning prayer givers and receivers
 * ensuring no one prays for or receives prayer from the same person.
 * The draw method performs the randomization process.
 *
 * @author João Guedes
 */
public class PrayerPairRaffler implements Raffler {

    private final Random random = new Random();

    /**
     * Draws random prayer pairs from the list of participants.
     * This method shuffles the participants and then selects who will pray for whom.
     *
     * @param participants The list of participants involved in the prayer.
     */
    @Override
    public void draw(List<String> participants) {
        List<String> shuffledParticipants = shuffle(participants);

        List<String> prayGroup = new LinkedList<>(shuffledParticipants);
        List<String> receiveGroup = new LinkedList<>(shuffledParticipants);

        this.draw(prayGroup, receiveGroup);
    }

    /**
     * Randomly selects who will pray for whom from the given groups of prayer givers and receivers.
     * This method continues to draw pairs recursively until valid pairs are found.
     *
     * @param prayGroup The list of participants who will pray.
     *
     * @param receiveGroup The list of participants who will receive prayer.
     */
    private void draw(List<String> prayGroup, List<String> receiveGroup) {
        if (prayGroup.isEmpty() || receiveGroup.isEmpty()) {
            return;
        }

        String prayerGiver = getRandomParticipant(prayGroup);
        String prayerReceiver = getRandomParticipant(receiveGroup);

        prayGroup.remove(prayerGiver);
        receiveGroup.remove(prayerReceiver);

        if (isValidPair(prayerGiver, prayerReceiver, prayGroup, receiveGroup)) {
            Renderer.renderPrayerPair(prayerGiver, prayerReceiver);
        } else {
            prayGroup.add(prayerGiver);
            receiveGroup.add(prayerReceiver);
        }

        this.draw(prayGroup, receiveGroup);
    }

    /**
     * Shuffles the provided list of participants to randomize their order.
     *
     * @param list The list of participants to be shuffled.
     *
     * @param <T> The type of elements in the list.
     *
     * @return A new list with the participants shuffled in random order.
     */
    private <T> List<T> shuffle(List<T> list) {
        List<T> shuffled = new LinkedList<>(list);
        Collections.shuffle(shuffled);
        return shuffled;
    }

    /**
     * Selects a random participant from the provided list.
     *
     * @param participants The list of participants to select from.
     *
     * @return A randomly selected participant from the list.
     */
    private String getRandomParticipant(List<String> participants) {
        return participants.get(random.nextInt(participants.size()));
    }

    /**
     * Checks whether a given prayer giver and receiver form a valid pair.
     * A valid pair means that the prayer giver and receiver are not the same person
     * if there are other and that no participant is both a prayer giver and receiver
     * for the same person.
     *
     * @param prayerGiver The person who will pray.
     *
     * @param prayerReceiver The person who will receive prayer.
     *
     * @param prayGroup The remaining prayer givers who still need to be assigned.
     *
     * @param receiveGroup The remaining prayer receivers who still need to be assigned.
     *
     * @return true if the pair is valid, false otherwise.
     */
    private boolean isValidPair(String prayerGiver, String prayerReceiver, List<String> prayGroup, List<String> receiveGroup) {
        if (prayerGiver.equals(prayerReceiver) && receiveGroup.isEmpty()) {
            return true;
        }

        if (prayerGiver.equals(prayerReceiver)) {
            return false;
        }

        return prayGroup.size() != 1 || prayGroup.stream().noneMatch(receiveGroup::contains);
    }

}
