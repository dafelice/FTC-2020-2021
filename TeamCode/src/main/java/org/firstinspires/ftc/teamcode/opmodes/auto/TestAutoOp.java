package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.config.RobotHardware;
import org.firstinspires.ftc.teamcode.subsystem.DriveTrain;

public class TestAutoOp extends OpMode {

   /* public void hardwareInit(HardwareMap hardwareMap) {

        RobotHardware.FrontL = hardwareMap.dcMotor.get("FrontL");
    }
*/
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        RobotHardware.FrontL.setPower(1);
        RobotHardware.FrontR.setPower(1);
        RobotHardware.BackR.setPower(1);
        RobotHardware.BackL.setPower(1);
    }
}
