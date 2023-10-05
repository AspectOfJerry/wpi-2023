// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or the package after creating this project, you must also
 * update the build.gradle file in the project.
 */
public class Robot extends TimedRobot {
    // Constants
    private final double kDeadzone = 0.1;
    private final byte kXAxis = 0;
    private final byte kYAxis = 1;
    private final byte kLeftTriggerAxis = 2;
    private final byte kRightTriggerAxis = 3;

    private final byte kAButton = 1;

    private final WPI_TalonFX motor1 = new WPI_TalonFX(1);
    private final WPI_TalonFX motor2 = new WPI_TalonFX(2);

    private final DigitalInput button = new DigitalInput(5);

    private Orchestra orchestra;

    private boolean AButtonState = false;

    /*
     * Joystick ports
     * Driver: 0
     * Operator: 1
     */
    private final Joystick joystick = new Joystick(0);

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        // motor1.setInverted(true);
        // motor2.follow(falconMaster);

        ArrayList<TalonFX> instruments = new ArrayList<TalonFX>();
        instruments.add(motor1);
        instruments.add(motor2);

        orchestra = new Orchestra(instruments);
        orchestra.loadMusic(".\\assets\\music.chrp");
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        orchestra.play();
    }

    @Override
    public void teleopPeriodic() {
        if (joystick.getRawButtonPressed(kAButton)) {
            AButtonState = !AButtonState;
        }

        double leftJoystickPosX = joystick.getRawAxis(kXAxis);
        double leftJoystickPosY = -joystick.getRawAxis(kYAxis);
        double leftTrigger = joystick.getRawAxis(kLeftTriggerAxis);
        double rightTrigger = joystick.getRawAxis(kRightTriggerAxis);

        // set motor with a joystick
        motor1.set(Math.abs(leftJoystickPosY) <= kDeadzone ? 0 : joystick.getRawAxis(kYAxis));

        boolean buttonPressed = button.get();
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    // @Override
    // public void testInit() {
    // }

    // @Override
    // public void testPeriodic() {
    // }

    // @Override
    // public void simulationInit() {
    // }

    // @Override
    // public void simulationPeriodic() {
    // }
}
