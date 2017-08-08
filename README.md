# FlexionTest
Billing Integration Test for Flexion

This software is a Java Console application to make it easy to test. FlexionTest2.java contains the main method.

The IntegrationTestRunner performs an automated test but does not try to pass null for paramaters.
Interestingly, the buy REST operation accepts null for itemID.
Also, it would be worthwhile to test more than one purchase so that the list of purchases would include at least two items.

This implementation of the Integration includes the developer ID as a constant in the IntegrationImpl class.
