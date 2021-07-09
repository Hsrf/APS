nome = input('Qual nome da variável? ')
tipo = input('Qual o tipo da variável? ')
condicional = input('get ou set? ')
if condicional == 'get':
    print('\npublic', tipo, condicional+nome.capitalize()+'(){\n\t return this.'+nome+';\n}')
elif condicional == 'set':
    print('\npublic', 'void', condicional+nome.capitalize()+'('+tipo+' '+nome+')'+'{\n\t this.'+nome+'='+nome+';\n}')