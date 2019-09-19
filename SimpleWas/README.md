# Simple Was Server

## Dependencies
	* All other dependencies are managed by Maven.

## Installation
```
	.\install.sh
```
or manually :
```
	mvn clean install
```

## Architecture

### Project Architecture

- controller : Rest API call from POST
- kafka :  The example of kafka Producer & Consumer
- model :  Object Resbean
- service :  Rest service with initializer

**Note**
To format Json to Java, it's using [Gson API](https://github.com/google/gson).

## LICENSE
	Copyright (c) 2017 Worldline
    License: GNU General Public License version 3, see COPYING
