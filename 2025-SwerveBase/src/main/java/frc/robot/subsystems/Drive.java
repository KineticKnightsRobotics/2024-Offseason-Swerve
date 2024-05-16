package frc.robot.subsystems;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import frc.robot.Constants;
import frc.robot.lib.PID_Config.SwereModule;
import frc.robot.lib.SwerveModule;


public class Drive extends SubsystemBase {
    private static SwerveModule FrontLeft;

    private static SwerveModule FrontRight;
    
    private static SwerveModule BackLeft;

    private static SwerveModule BackRight;




    public Drive(){
        FrontLeft = new SwerveModule(
            "FrontLeft",
         Constants.SwerveModules.FrontLeft.driveID,
          Constants.SwerveModules.FrontLeft.turnID, 
          Constants.SwerveModules.FrontLeft.absoluteEncoderID, 
          Constants.SwerveModules.FrontLeft.absoluteOffset, 
          Constants.SwerveModules.invertTurn, 
          Constants.SwerveModules.invertDrive);
        FrontRight = new SwerveModule(
            "FrontRight",
         Constants.SwerveModules.FrontRight.driveID,
          Constants.SwerveModules.FrontRight.turnID, 
          Constants.SwerveModules.FrontRight.absoluteEncoderID, 
          Constants.SwerveModules.FrontRight.absoluteOffset, 
          Constants.SwerveModules.invertTurn, 
          Constants.SwerveModules.invertDrive);
        BackLeft = new SwerveModule(
            "BackLeft",
         Constants.SwerveModules.BackLeft.driveID,
          Constants.SwerveModules.BackLeft.turnID, 
          Constants.SwerveModules.BackLeft.absoluteEncoderID, 
          Constants.SwerveModules.BackLeft.absoluteOffset, 
          Constants.SwerveModules.invertTurn, 
          Constants.SwerveModules.invertDrive);
        BackRight = new SwerveModule(
            "BackRight",
         Constants.SwerveModules.BackRight.driveID,
          Constants.SwerveModules.BackRight.turnID, 
          Constants.SwerveModules.BackRight.absoluteEncoderID, 
          Constants.SwerveModules.BackRight.absoluteOffset, 
          Constants.SwerveModules.invertTurn, 
          Constants.SwerveModules.invertDrive);
    
    }


    @Override
    public void periodic() {
        
    }



    public static void setModuleStates(ChassisSpeeds chassisSpeed) {
        SwerveModuleState[] states = Constants.SwerveDrive.chassisKinematics.toSwerveModuleStates(chassisSpeed);



    } 




    
}
