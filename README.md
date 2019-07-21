Password-Change is the maven project.
It requires Java 8.
It has 2 source folder, one contains the src file which has ChangePassword function and other is test folder which has all the unit test for ChangePassword function.
                
To run it from Eclipse follow the below steps:
                
1. Import the maven project.
2. Update the maven project.
3. Run the App.java to run the ChangePassword function.
4. Run the AppTest.java to run the unit test of ChangePassword function.               

                
Cases handled in unit test:
1. Password should have only specified special char.
2. All the password requirement.
3. Both new and old password should not be blank or null.
4. Old password should match with system stored password.
5. password is not similar to old password < 80% match.
6. 50 % of password should not be a number.
7. No duplicate repeat characters more than 4.
8. No more than 4 special characters. 
