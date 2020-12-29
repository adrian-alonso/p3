# define a makefile variable for the java compiler
#
JCC = javac

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -classpath /opt/tomcat/lib/servlet-api.jar

# typing 'make' will invoke the first target entry in the makefile
# (the default one in this case)
#
default:
	$(JCC) $(JFLAGS) Degree.java Subject.java Student.java WarningFile.java ErrorFile.java FatalErrorFile.java BeanP01.java BeanP02.java BeanP11.java BeanP12.java BeanP13.java BeanBadPassword.java BeanNoParam.java BeanNoPassword.java EAML_ErrorHandler.java Parser.java FrontEnd.java Sint101P3.java


# To start over from scratch, type 'make clean'.
# Removes all .class files, so that the next make rebuilds them
#
clean:
	$(RM) *.class
