import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

List<Integer> organizarLista(List<Integer> lista){
    
    if(lista.get(0) > lista.get(1))
        Collections.swap(lista, 0, 1);

    if(lista.get(1) > lista.get(2)){
        Collections.swap(lista, 1, 2);

        if(lista.get(0) > lista.get(1))
            Collections.swap(lista, 0, 1);
    }

    return lista;
}

List<Integer> lerTresInteiros(){
    int quantidade = 3;
    List<Integer> lista = new ArrayList<>(quantidade);
    for (int i = 0; i < quantidade; i++) {
        int valor  = Integer.parseInt(IO.readln("Digite um número inteiro positivo: "));
        lista.add(valor);
    }
    lista = organizarLista(lista);
    return lista;
}

int produtoImpares(List<Integer> lista){
    int produto = 1;
    int inicio = lista.get(0);
    if(inicio % 2 == 0)
        inicio++;

    for (int i = inicio; i <= lista.get(2); i+=2) {
        produto = produto * i;
    }
    return produto;
}

List<Integer> divisiveisPeloMenor(List<Integer> lista){
    List<Integer> divisiveis = new LinkedList<>();

    int menor = lista.get(0);
    for(int i = lista.get(1); i <= lista.get(2); i++){
        if(i % menor == 0)
            divisiveis.add(i);
    }

    return divisiveis;

}


void main(){
    List<Integer> lista;
    int produto;
    List<Integer> divisiveis;
    String resposta;

    lista = lerTresInteiros();
    produto = produtoImpares(lista);
    divisiveis = divisiveisPeloMenor(lista);

    resposta = String.format("O produto dos ímpares entre %d e %d é %d.", lista.get(0), lista.get(2), produto);
    IO.println(resposta);

    resposta = String.format("Os números divisíveis por %d entre %d e %d são:" , lista.get(0), lista.get(1), lista.get(2));
    IO.println(resposta);

    for(int i = 0; i < divisiveis.size(); i++){
        IO.println((i+1) + ": " + divisiveis.get(i));
    }

}
