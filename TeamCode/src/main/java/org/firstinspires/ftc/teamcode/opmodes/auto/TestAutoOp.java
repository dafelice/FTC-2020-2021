package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.config.RobotHardware;
import org.firstinspires.ftc.teamcode.subsystem.DriveTrain;

public class TestAutoOp extends OpMode {
    DriveTrain driveTrain = new DriveTrain();

   /* public void hardwareInit(HardwareMap hardwareMap) {

        RobotHardware.FrontL = hardwareMap.dcMotor.get("FrontL");
    }
*/
    @Override
    public void init() {

        //inits hardware
        driveTrain.hardwareInit(hardwareMap);
        //sets up Auto for use
        driveTrain.init_Auto(4000, telemetry);
    }

    @Override
    public void loop() {

        //motor drives forward for 4000 ticks
        driveTrain.setMotorPower(1);
        driveTrain.testMotors(telemetry);
    }
}
