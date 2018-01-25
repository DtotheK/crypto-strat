# crypto-strat
A simple Java project which uses historic data to indicate how successful the chosen strategy would be.

## Disclaimer
This application is for entertainment purposes only, and in no way should be used for basing your trading or financial decisions.

If you are trading cryptocurrencies, remember:
1. Don't put in more than you can afford to live without
2. Don't FOMO

This application is in a proof-of-concept stage, early alpha.

## Overview
This Java application will retrieve historical prices of Ripple's XRP digital asset, and will simulate trades. The application includes two rudimentary trading strategies. A simulation is performed, after which the results are displayed. 

## Algorithms
1. SHBL: Sell High Buy Low.
2. HODL: Hold on for dear life. Popular misspelling of HOLD, which itself is a popular strategy when it comes to crypto.

## Code
Obviously, this is small project. I do plan on expanding on it. Feel free to do with it what you wish. 

I'm quite happy with the overall structure, but there is one area which needs much more attention which is basically how currency is treated throughout the application. This is a limiting factor, and affects all aspects - the input data, the trades, the exchange rate, Wallets. etc.

Another area for improvement is that the input data is fixed, hardcoded to use December 2017 XRP prices. I am considering the best way to handle the change required to facilitate more options. The coinAPI is slightly limiting.

## Future Plans
- Generalise, add more crypto options.
- Rename the project. Someone has the twitter handle cryptostrat already. 
- Flexible, allow trader to have many crypto wallets.
- Add more historic-data options, such as different periods
- Add more complex algorithms
- Run algorithms on a range of trader parameters to determine optimal parameters.
- Test, and add automated tests, improve quality
- Horizon 3: Potentially add a simple front end with Spring framework, and host for anyone to use. 

## Typical Output

```
   ___                 _        __ _             _   
  / __\ __ _   _ _ __ | |_ ___ / _\ |_ _ __ __ _| |_ 
 / / | '__| | | | '_ \| __/ _ \\ \| __| '__/ _` | __|
/ /__| |  | |_| | |_) | || (_) |\ \ |_| | | (_| | |_ 
\____/_|   \__, | .__/ \__\___/\__/\__|_|  \__,_|\__|
           |___/|_|


Data Length: 30
[%:0.0]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.052127685]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.010920125]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.0059292666]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.0012194723]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.047462407]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.07079839]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.06848621]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.15088396]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.0026528924]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.034664746]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.07995204]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.49794236]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.26799452]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.81562126]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.13031027]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.015326605]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.04092065]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.07066471]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.013371274]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.044832446]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.5766614]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.066448145]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.013254537]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.024047837]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:-0.02264037]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.08062339]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.12510258]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.040626496]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]
[%:0.537658]No action taken, HODL...	
   ...completed trading. [F: 10000.0, C:37000.0]


	Days simulated: 30
---------------------------------
	Crypto		FIAT
Start	37,000.00	10,000.00
End	37,000.00	10,000.00
Gains	0.00		0.00
---------------------------------
Total FIAT at start: 18,695.00
Total FIAT at end: 81,407.406
```
