import sys
NumOfPokemon, NQuestion = map(int, sys.stdin.readline().split())
Pokemon = []
PokemonD = {}
for inputPokemon in range(NumOfPokemon):
    pokemonin = sys.stdin.readline().rstrip()
    Pokemon.append(pokemonin)
    PokemonD[pokemonin] = inputPokemon + 1
for order in range(NQuestion):
    Question = sys.stdin.readline().rstrip()
    Num = 0
    if Question[0] >= '0' and Question[0] <= '9':
        Num = int(Question)
        print(Pokemon[Num-1])
    else:
        print(PokemonD[Question])
