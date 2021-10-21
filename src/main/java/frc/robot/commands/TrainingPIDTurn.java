// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.commands;
 
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
 
public class TrainingPIDTurn extends CommandBase {
 
    private Drivetrain driveTrain;
 
    private ___ kP = .00725; // Used in tandem with error to make sure Romi is precise in its rotation
    private ___ kD = 0.0004; // Used in tandem with error to make sure Romi is precise in its rotation
    private ___ target; // Angle that we want to rotate, this is something we want to be very precise 
    private double tolerance;
 
    private double error;
    private double previousError;
    private double derivative = 0;
 
    public TrainingPIDTurn(Drivetrain driveTrain, ___ target, double tolerance) { // Same data type as you defined them in the code above, just fill in
    addRequirements(driveTrain);
    this.driveTrain = driveTrain;
    this.target = target;
    this.tolerance = tolerance;
  }
 
@Override
  public void initialize() {
    driveTrain.resetGyro();
    error = target - driveTrain.getHeading();
  }
 
  @Override
  public void execute() {
      double startTime = Timer.getFPGATimestamp();
      double power = Math.abs((error * kP) + (derivative * kD));
      if (error ___ 0) { //Checking if error is greater than 0
        driveTrain.arcadeDrive(0, -power);
      } else {
        driveTrain.arcadeDrive(0, power);
      }
      previousError = error;
      error = target - driveTrain.getHeading();
      derivative = (error - previousError) / (Timer.getFPGATimestamp() - startTime) * kD;
      System.out.println("Runtime Power: " + power);
      System.out.println("Runtime Error: " + error);
  }
 
  @Override
  public void end(boolean interrupted) {
    driveTrain.arcadeDrive(0, 0);
    System.out.println("End Angle: " + driveTrain.getHeading());
  }
 
  @Override
  public boolean isFinished() {
    return Math.abs(error) ___ tolerance; // Checking if the robot’s error is less than or equal to the tolerance, basically if the Romi has reached its target angle
  }
}
 
