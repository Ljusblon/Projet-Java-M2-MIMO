JC = javac

SRC = Jauge \
	Position \
	Passager \
	Usager \
	Vehicule \
	Transport \
	Autobus \
	Arret \
	ArretCalme \
	ArretNerveux \
	ArretPrudent \
	ArretAgoraphobe \
	ArretPoli \
	PassagerAbstrait \
	MonteeFatigue \
	MonteeSportif \
	MonteeTetu \
	MonteeRepos \
	Collecte \
	CollecteFichier \
	CollecteTableau \
	Simple \
	SimpleCollecteFichier \
	SimpleCollecteTableau \
	TecException

TST = LancerTests \
    TestJauge \
	TestPosition \
	TestAutobus \
	TestArretAgoraphobe \
	TestArretCalme \
	TestArretNerveux \
	TestArretPoli \
	TestArretPrudent \
	TestMonteeFatigue \
	TestMonteeRepos \
	TestMonteeSportif \
	TestMonteeTetu \
	TestPassagerAbstrait \
	TestCollecteFichier \
	TestCollecteTableau 

MCK = FauxVehicule \
	FauxPassager \
	FauxPassagerAbstrait

all: compile

compile: $(addprefix src/, $(addsuffix .java, $(SRC)))
	@$(JC) $^ -cp build -d build

simple: simple-sans-collecte simple-collecte-tableau simple-collecte-fichier

simple-sans-collecte: compile
	@java -ea -cp build Simple

simple-collecte-tableau: compile
	@java -ea -cp build SimpleCollecteTableau

simple-collecte-fichier: compile
	@java -ea -cp build SimpleCollecteFichier
	@cat build/data.txt

compile-test: $(addprefix tst/, $(addsuffix .java, $(TST))) $(addprefix tst/, $(addsuffix .java, $(MCK)))
	@$(JC) $^ -cp build -d build

test: compile compile-test
	@java -ea -cp build tec.LancerTests $(TST)

clean:
	@rm -rf build/* *~ \#*
	@touch build/.keep


.PHONY = all compile compile-test test clean
