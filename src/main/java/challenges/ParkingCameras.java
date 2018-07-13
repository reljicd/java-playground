package challenges;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given a task of installing video cameras that will detect where cars are parked on one side of the street.  Each camera can cover one or more parking spaces around it, as defined by cameraRange parameter. Camera will always be installed on top of a specific parking space.
 * <p>
 * Your job is to implement a function that, given a list of all possible parking space locations on the street, will return a minimum number of cameras needed to detect cars in all those parking spaces. Each parking space spans 1 unit of space, spaces start at index 1. REMEMBER that camera can only be installed on top of an existing parking space.
 * <p>
 * In Android or Swift, implement the following function:
 * <p>
 * int findMinimumNumberOfCameras(int cameraRange, int[] parkingSpaces)
 * <p>
 * OR
 * <p>
 * func findMinimumNumberOfCameras(cameraRange: Int, parkingSpaces: [Int]) -> Int
 * <p>
 * Example 1:
 * cameraRange = 1
 * parkingSpaces = [1 , 2, 3, 4, 5]
 * <p>
 * The result here is 2. If you place one camera on space 2, it will cover spaces 1, 2, and 3 (covers both ways), and camera on space 4 will cover space 4 and 5. It's ok to "double-cover" spaces.
 * <p>
 * Example 2:
 * cameraRange = 2
 * parkingSpaces = [2, 4, 5, 6, 7, 9, 11, 12]
 * <p>
 * The result is 3. The optimal coverage will be achieved if you install cameras at locations 4, 9 and 12.  Camera at 4 will cover spaces 2, 4, 5, and 6. Camera at 9 will cover 7, 9, and 11. Finally, camera at 12 will cover 12.
 * <p>
 * Example 3:
 * cameraRange = 10
 * parkingSpaces = [1, 15, 30, 40, 50]
 * <p>
 * The result is 3. You would need one camera at 1, another at 15, and 3rd one at 40.
 * <p>
 * cameraRange can go up to 10 spaces, and each street can have 100 parking spaces.
 * <p>
 * ------------------------------------------------------------------------------------------
 * <p>
 * I implemented solution using the next approach:
 * I start from the first uncovered spot and try to find the spot (index) for camera so that I cover maximum possible
 * spots that I can while including that first uncovered spot also.
 * I implemented that functionality in findNextCameraIndex helper method.
 * Each time i find the next spot for camera, I increment numberOfCameras.
 * I stop with search for camera spots once I am sure I covered all the spots with cameras.
 */
class ParkingCameras {

    static int findMinimumNumberOfCameras(int cameraRange, int[] parkingSpaces) {
        return findCameraIndexes(cameraRange, parkingSpaces).size();
    }

    static List<Integer> findCameraIndexes(int cameraRange, int[] parkingSpaces) {
        LinkedList<Integer> cameraIndexesList = new LinkedList<>();

        cameraIndexesList.add(findNextCameraIndex(0, cameraRange, parkingSpaces));

        for (int startIndex = 1; startIndex < parkingSpaces.length; startIndex++) {
            // Skip spots already covered by last installed camera
            if (isSpotCoveredByCamera(parkingSpaces, startIndex, cameraIndexesList.getLast(), cameraRange)) continue;
            cameraIndexesList.add(findNextCameraIndex(startIndex, cameraRange, parkingSpaces));
        }

        return cameraIndexesList;
    }

    /**
     * Helper method for finding spot (index) where we should put the next camera
     */
    private static int findNextCameraIndex(int startIndex, int cameraRange, int[] parkingSpaces) {
        int maximumCoveredSpots = 0;
        int nextCameraIndex = 0;

        for (int cameraIndex = startIndex; cameraIndex < parkingSpaces.length; cameraIndex++) {
            // Break once we start iterating over spots that don't include startIndex (first uncovered) spot in camera range
            if (!isSpotCoveredByCamera(parkingSpaces, startIndex, cameraIndex, cameraRange)) break;

            int coveredSpots = 0;
            for (int spotIndex = startIndex; spotIndex < parkingSpaces.length; spotIndex++) {
                if (isSpotCoveredByCamera(parkingSpaces, spotIndex, cameraIndex, cameraRange)) coveredSpots++;
            }

            if (coveredSpots > maximumCoveredSpots) {
                maximumCoveredSpots = coveredSpots;
                nextCameraIndex = cameraIndex;
            }
        }
        return nextCameraIndex;
    }

    private static boolean isSpotCoveredByCamera(int[] parkingSpaces, int spotIndex, int cameraIndex, int cameraRange) {
        return Math.abs(parkingSpaces[spotIndex] - parkingSpaces[cameraIndex]) <= cameraRange;
    }

}

