package challenges;

/**
 * You are given a task of installing video cameras that will detect where cars are parked on one side of the street.  Each camera can cover one or more parking spaces around it, as defined by cameraRange parameter. Camera will always be installed on top of a specific parking space.
 *
 * Your job is to implement a function that, given a list of all possible parking space locations on the street, will return a minimum number of cameras needed to detect cars in all those parking spaces. Each parking space spans 1 unit of space, spaces start at index 1. REMEMBER that camera can only be installed on top of an existing parking space.
 *
 * In Android or Swift, implement the following function:
 *
 * int findMinimumNumberOfCameras(int cameraRange, int[] parkingSpaces)
 *
 * OR
 *
 * func findMinimumNumberOfCameras(cameraRange: Int, parkingSpaces: [Int]) -> Int
 *
 * Example 1:
 * cameraRange = 1
 * parkingSpaces = [1 , 2, 3, 4, 5]
 *
 * The result here is 2. If you place one camera on space 2, it will cover spaces 1, 2, and 3 (covers both ways), and camera on space 4 will cover space 4 and 5. It's ok to "double-cover" spaces.
 *
 * Example 2:
 * cameraRange = 2
 * parkingSpaces = [2, 4, 5, 6, 7, 9, 11, 12]
 *
 * The result is 3. The optimal coverage will be achieved if you install cameras at locations 4, 9 and 12.  Camera at 4 will cover spaces 2, 4, 5, and 6. Camera at 9 will cover 7, 9, and 11. Finally, camera at 12 will cover 12.
 *
 * Example 3:
 * cameraRange = 10
 * parkingSpaces = [1, 15, 30, 40, 50]
 *
 * The result is 3. You would need one camera at 1, another at 15, and 3rd one at 40.
 *
 * cameraRange can go up to 10 spaces, and each street can have 100 parking spaces.
 *
 * ------------------------------------------------------------------------------------------
 *
 * I implemented solution using the next approach:
 * I start from the first uncovered spot and try to find the spot (index) for camera so that I cover maximum possible
 * spots that I can while including that first uncovered spot also.
 * I implemented that functionality in findNextCameraIndex helper method.
 * Each time i find the next spot for camera, I increment numberOfCameras.
 * I stop with search for camera spots once I am sure I covered all the spots with cameras.
 */
class ParkingCameras {
    static int findMinimumNumberOfCameras(int cameraRange, int[] parkingSpaces) {
        int numberOfCameras = 0;
        int currentCameraIndex = 0;

        for (int i = 0; i < parkingSpaces.length; i++) {
            // We already covered all the spots, so we can skip further iterations
            if (parkingSpaces[parkingSpaces.length - 1] - cameraRange <= parkingSpaces[currentCameraIndex]) break;
            // Skip covered spots by last installed camera
            if (Math.abs(parkingSpaces[i] - parkingSpaces[currentCameraIndex]) <= cameraRange && i != 0) continue;

            currentCameraIndex = findNextCameraIndex(i, cameraRange, parkingSpaces);
            numberOfCameras++;
        }

        return numberOfCameras;
    }

    /**
     * Helper method for finding spot (index) where we should put the next camera
     */
    private static int findNextCameraIndex(int firstIndex, int cameraRange, int[] parkingSpaces) {
        int maximumCoveredSpots = 0;
        int nextCameraIndex = 0;

        for (int i = firstIndex; i < parkingSpaces.length; i++) {
            // Break once we start iterating over spots that don't include firstIndex (first uncovered) spot in camera range
            if (Math.abs(parkingSpaces[i] - parkingSpaces[firstIndex]) > cameraRange) break;

            int coveredSpots = 0;
            for (int j = firstIndex; j < parkingSpaces.length; j++) {
                if (Math.abs(parkingSpaces[i] - parkingSpaces[j]) <= cameraRange) coveredSpots++;
            }

            if (coveredSpots > maximumCoveredSpots) {
                maximumCoveredSpots = coveredSpots;
                nextCameraIndex = i;
            }
        }

        return nextCameraIndex;
    }

}

