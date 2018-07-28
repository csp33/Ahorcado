from Letra import Letra
class Palabra:
    def __init__(self,entrada):
        self.palabra=[]
        for letra in entrada:
            l=Letra(letra)
            self.palabra.append(l)

    def contiene(self,letra):
        resultado=False
        for l in self.palabra:
            if l.comprobar(letra):
                resultado=True
        return resultado

    def acertada(self):
        for l in self.palabra:
            if not l.acertada:
                return False
        return True

    def get_palabra(self):
        resultado=""
        for l in self.palabra:
            letra=str(l.get_letra())
            resultado+=letra
        return resultado
