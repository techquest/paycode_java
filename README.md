# paycode_java

[Support chat](https://interswitch.slack.com/messages/C4ULTK04T/)

This repository contains Java SDK and samples for Paycode

## Prerequisites
* Java JDK 6 or higher
* An environment which supports TLS 1.2
* Interswitch Base Library [Click here](https://github.com/techquest/interswitch_java)

Welcome
================================
##### [Read our FAQs here](https://github.com/techquest/paycode_java/wiki/FAQ)

### Paycode  
A paycode is a one time code used for withdrawing cash at the ATM. It can also be used to make payment on a POS terminal. You can withdraw Paycode at the folloing banks ATM: GTB, Fidelity,

### Bulk Paycode  
A paycode is a one time code used for withdrawing cash at the ATM. It can also be used to make payment on a POS terminal. You can withdraw Paycode at the folloing banks ATM: GTB, Fidelity,

Generate Paycode from account
Generate Paycode from PAN
Generate Bulk paycode





What this SDK provides for you
================================

### Get All Billers  
	Get a list of all billers supported on our platform.

### Get All Categorys  
  	Get a list of all categorys and associated billers supported on our platform.

### Get All Billers under a Category  
	Get a list of all biilers under a particular category.
	
### Get Biller Payment Items  
	Get a list of all payment-items under aparticular Biller.

### Validate Customer  
	Validates a customer-id under a particular biller.

### Make payment for a customer  
	Makes a payment for a payment-item for a particular customer.
	
### Query the status of a transaction  
    Query the status of a transaction made in the past based on the Request Reference




Quick start
===============================

#### Maven 
    <dependency>
        <groupId>com.interswitch</groupId>
        <artifactId>interswitch-java</artifactId>
        <version>0.0.1</version>
    </dependency>

#### Samples

Check out the samples folder for sample code on all the features above.

#### Support Team

Still experiencing issues, quickly talk to our Engineers at
[Support chat](https://interswitch.slack.com/messages/C4ULTK04T/) or [Support chat](https://gitter.im/techquest) and get your issues fixed in a giffy.
