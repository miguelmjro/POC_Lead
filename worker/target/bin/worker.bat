@REM ----------------------------------------------------------------------------
@REM Copyright 2001-2004 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM ----------------------------------------------------------------------------
@REM

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\org\springframework\boot\spring-boot-starter-data-jpa\1.5.7.RELEASE\spring-boot-starter-data-jpa-1.5.7.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-starter\1.5.7.RELEASE\spring-boot-starter-1.5.7.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot\1.5.7.RELEASE\spring-boot-1.5.7.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-autoconfigure\1.5.7.RELEASE\spring-boot-autoconfigure-1.5.7.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-logging\1.5.7.RELEASE\spring-boot-starter-logging-1.5.7.RELEASE.jar;"%REPO%"\ch\qos\logback\logback-classic\1.1.11\logback-classic-1.1.11.jar;"%REPO%"\ch\qos\logback\logback-core\1.1.11\logback-core-1.1.11.jar;"%REPO%"\org\slf4j\jul-to-slf4j\1.7.25\jul-to-slf4j-1.7.25.jar;"%REPO%"\org\slf4j\log4j-over-slf4j\1.7.25\log4j-over-slf4j-1.7.25.jar;"%REPO%"\org\yaml\snakeyaml\1.17\snakeyaml-1.17.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-aop\1.5.7.RELEASE\spring-boot-starter-aop-1.5.7.RELEASE.jar;"%REPO%"\org\springframework\spring-aop\4.3.11.RELEASE\spring-aop-4.3.11.RELEASE.jar;"%REPO%"\org\aspectj\aspectjweaver\1.8.10\aspectjweaver-1.8.10.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-jdbc\1.5.7.RELEASE\spring-boot-starter-jdbc-1.5.7.RELEASE.jar;"%REPO%"\org\apache\tomcat\tomcat-jdbc\8.5.20\tomcat-jdbc-8.5.20.jar;"%REPO%"\org\apache\tomcat\tomcat-juli\8.5.20\tomcat-juli-8.5.20.jar;"%REPO%"\org\springframework\spring-jdbc\4.3.11.RELEASE\spring-jdbc-4.3.11.RELEASE.jar;"%REPO%"\org\hibernate\hibernate-core\5.0.12.Final\hibernate-core-5.0.12.Final.jar;"%REPO%"\org\jboss\logging\jboss-logging\3.3.1.Final\jboss-logging-3.3.1.Final.jar;"%REPO%"\org\hibernate\javax\persistence\hibernate-jpa-2.1-api\1.0.0.Final\hibernate-jpa-2.1-api-1.0.0.Final.jar;"%REPO%"\org\javassist\javassist\3.21.0-GA\javassist-3.21.0-GA.jar;"%REPO%"\antlr\antlr\2.7.7\antlr-2.7.7.jar;"%REPO%"\org\jboss\jandex\2.0.0.Final\jandex-2.0.0.Final.jar;"%REPO%"\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;"%REPO%"\org\hibernate\common\hibernate-commons-annotations\5.0.1.Final\hibernate-commons-annotations-5.0.1.Final.jar;"%REPO%"\org\hibernate\hibernate-entitymanager\5.0.12.Final\hibernate-entitymanager-5.0.12.Final.jar;"%REPO%"\javax\transaction\javax.transaction-api\1.2\javax.transaction-api-1.2.jar;"%REPO%"\org\springframework\data\spring-data-jpa\1.11.7.RELEASE\spring-data-jpa-1.11.7.RELEASE.jar;"%REPO%"\org\springframework\data\spring-data-commons\1.13.7.RELEASE\spring-data-commons-1.13.7.RELEASE.jar;"%REPO%"\org\springframework\spring-orm\4.3.11.RELEASE\spring-orm-4.3.11.RELEASE.jar;"%REPO%"\org\springframework\spring-context\4.3.11.RELEASE\spring-context-4.3.11.RELEASE.jar;"%REPO%"\org\springframework\spring-tx\4.3.11.RELEASE\spring-tx-4.3.11.RELEASE.jar;"%REPO%"\org\springframework\spring-beans\4.3.11.RELEASE\spring-beans-4.3.11.RELEASE.jar;"%REPO%"\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;"%REPO%"\org\slf4j\jcl-over-slf4j\1.7.25\jcl-over-slf4j-1.7.25.jar;"%REPO%"\org\springframework\spring-aspects\4.3.11.RELEASE\spring-aspects-4.3.11.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-thymeleaf\1.5.7.RELEASE\spring-boot-starter-thymeleaf-1.5.7.RELEASE.jar;"%REPO%"\org\thymeleaf\thymeleaf-spring4\2.1.5.RELEASE\thymeleaf-spring4-2.1.5.RELEASE.jar;"%REPO%"\org\thymeleaf\thymeleaf\2.1.5.RELEASE\thymeleaf-2.1.5.RELEASE.jar;"%REPO%"\ognl\ognl\3.0.8\ognl-3.0.8.jar;"%REPO%"\org\unbescape\unbescape\1.1.0.RELEASE\unbescape-1.1.0.RELEASE.jar;"%REPO%"\nz\net\ultraq\thymeleaf\thymeleaf-layout-dialect\1.4.0\thymeleaf-layout-dialect-1.4.0.jar;"%REPO%"\org\codehaus\groovy\groovy\2.4.12\groovy-2.4.12.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-web\1.5.7.RELEASE\spring-boot-starter-web-1.5.7.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-tomcat\1.5.7.RELEASE\spring-boot-starter-tomcat-1.5.7.RELEASE.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-core\8.5.20\tomcat-embed-core-8.5.20.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-el\8.5.20\tomcat-embed-el-8.5.20.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-websocket\8.5.20\tomcat-embed-websocket-8.5.20.jar;"%REPO%"\org\hibernate\hibernate-validator\5.3.5.Final\hibernate-validator-5.3.5.Final.jar;"%REPO%"\javax\validation\validation-api\1.1.0.Final\validation-api-1.1.0.Final.jar;"%REPO%"\com\fasterxml\classmate\1.3.4\classmate-1.3.4.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-databind\2.8.10\jackson-databind-2.8.10.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-annotations\2.8.0\jackson-annotations-2.8.0.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-core\2.8.10\jackson-core-2.8.10.jar;"%REPO%"\org\springframework\spring-web\4.3.11.RELEASE\spring-web-4.3.11.RELEASE.jar;"%REPO%"\org\springframework\spring-webmvc\4.3.11.RELEASE\spring-webmvc-4.3.11.RELEASE.jar;"%REPO%"\org\springframework\spring-expression\4.3.11.RELEASE\spring-expression-4.3.11.RELEASE.jar;"%REPO%"\org\springframework\spring-core\4.3.11.RELEASE\spring-core-4.3.11.RELEASE.jar;"%REPO%"\org\postgresql\postgresql\9.4.1212.jre7\postgresql-9.4.1212.jre7.jar;"%REPO%"\com\iheartmedia\worker\1\worker-1.jar
set EXTRA_JVM_ARGUMENTS=
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% %EXTRA_JVM_ARGUMENTS% -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="worker" -Dapp.repo="%REPO%" -Dbasedir="%BASEDIR%" com.heroku.devcenter.BigOperationWorker %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal

:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
