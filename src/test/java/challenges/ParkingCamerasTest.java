package challenges;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingCamerasTest {

    @Test
    public void findMinimumNumberOfCameras() {
        assertThat(ParkingCameras.findMinimumNumberOfCameras(1, new int[]{1, 2, 3, 4, 5})).isEqualTo(2);
        assertThat(ParkingCameras.findMinimumNumberOfCameras(2, new int[]{2, 4, 5, 6, 7, 9, 11, 12})).isEqualTo(3);
        assertThat(ParkingCameras.findMinimumNumberOfCameras(10, new int[]{1, 15, 30, 40, 50})).isEqualTo(3);
    }

    @Test
    public void findCameraIndexes() {
        assertThat(ParkingCameras.findCameraIndexes(1, new int[]{1, 2, 3, 4, 5})).isEqualTo(Arrays.asList(1, 3));
        assertThat(ParkingCameras.findCameraIndexes(2, new int[]{2, 4, 5, 6, 7, 9, 11, 12})).isEqualTo(Arrays.asList(1, 5, 7));
        assertThat(ParkingCameras.findCameraIndexes(10, new int[]{1, 15, 30, 40, 50})).isEqualTo(Arrays.asList(0, 1, 3));
    }
}