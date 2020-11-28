package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

    @Test
    public void testLowPressureAlarm() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.0);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testHighPressureAlarm() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(27.0);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testRegularPressureAlarm() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(20.0);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}
