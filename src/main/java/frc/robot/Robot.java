// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

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
    private final double kDeadzone = 0.05;
    private final byte kXAxis = 0;
    private final byte kYAxis = 1;

    private final WPI_TalonFX falconMaster = new WPI_TalonFX(1);
    private final WPI_TalonFX falconFollower = new WPI_TalonFX(2);

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
        falconMaster.setInverted(true);
        falconFollower.follow(falconMaster);
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
    }

    @Override
    public void teleopPeriodic() {
        // set motor with a joystick
        falconMaster.set(Math.abs(joystick.getRawAxis(kYAxis)) <= kDeadzone ? 0 : joystick.getRawAxis(kYAxis));
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
