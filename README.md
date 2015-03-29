Mobile-Test-Automation-Framework
================================

This a draft project of a test automation framework which implements the core 
common objects in order to write any kind of test script. Common objects in 
mobile testing are for example the device, the application, test users, etc...

These scripts start with a simple domain specific language which should be
extended for each application flow.

Example DSL of a TestScript:

    TestScript          
       .on(device("device1.properties"))
       .with(app("sampleApp1.properties"))
       .execute(SampleAppScripts.SampleTest1.class)
       .report(toFile("sampleTest1.log"))
       .start();


The SampleAppScripts.SampleTest1 is a class that defines the test as follows:

    on(device)
       .installApp(app)
       .launchTo(LoginPage.class)
       .then()
       .typeUser(testUser.getUserName())
       .typePass(testUser.getPassword())
       .clickLoginButton();
            
    onPage(AppPage1.class)
       .waitWhileLoading()
       .verifyPage()
       .click(SampleApp.MainMenu.Option1)
       .verify(Popup.SampleMessage1);