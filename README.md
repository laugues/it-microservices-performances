# microservice-war-performance

## Deployment
Deploy all war on wildly 8:

```javascript
api.war
world.war
eu.war
fr.war
lr.war
itesoft.war
ps1.war
ps10.war
ps11.war
ps12.war
ps13.war
ps14.war
ps2.war
ps3.war
ps4.war
ps5.war
ps6.war
ps7.war
ps8.war
ps9.war
```



## Build
To build:
```javascript
gradle.bat wars
```

## Run
To call:
```javascript
POST: http://localhost:8080/api/rest/validateInvoice

invoice: {id: 1, status: "PAID", date: "2014-07-04T12:08:56.235-07:00",…}
batchName: "2016-125121"
code: "CODE"
companyId: 2
companyName: "MES MATERIAUX"
currency: "EUR"
custom1: "Cras semper arcu et ."
custom4: "2014-07-04T12:08:56.235-07:00"
custom5: "2014-07-04T12:08:56.235-07:00"
date: "2014-07-04T12:08:56.235-07:00"
dateChangeState: null
dueDate: "2014-07-04T12:08:56.235-07:00"
id: 1
number: 122000221
scanDate: "2014-07-04T12:08:56.235-07:00"
site: "PARIS"
status: "PAID"
supplierId: 1
supplierName: "POINTP"
totalAmount: 1095112.2
totalNetAmount: 105156.2
type: "INVOICE"
```"# it-microservices-performances" 
