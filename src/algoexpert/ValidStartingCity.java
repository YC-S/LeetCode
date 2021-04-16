package algoexpert;

public class ValidStartingCity {
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int numberOfCities = distances.length;
        int milesRemaining = 0;
        int indexOfStartingCityCandidate = 0;
        int milesRemainingAtStartingCityCandidate = 0;
        for (int cityIdx = 1; cityIdx < numberOfCities; cityIdx++) {
            int distanceFromPreviousCity = distances[cityIdx - 1];
            int fuelFromPreviousCity = fuel[cityIdx - 1];
            milesRemaining += fuelFromPreviousCity * mpg - distanceFromPreviousCity;

            if (milesRemaining < milesRemainingAtStartingCityCandidate) {
                milesRemainingAtStartingCityCandidate = milesRemaining;
                indexOfStartingCityCandidate = cityIdx;
            }
        }
        return indexOfStartingCityCandidate;
    }
}
