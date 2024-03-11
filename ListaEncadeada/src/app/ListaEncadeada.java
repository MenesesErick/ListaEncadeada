package app;

public class ListaEncadeada {
	
	private No inicio;
    private int tamanho;

    private class No {
        int dado;
        No proximo;

        No(int dado) {
            this.dado = dado;
        }
    }

    public void inserirInicio(int dado) {
        No novoNo = new No(dado);
        novoNo.proximo = inicio;
        inicio = novoNo;
        tamanho++;
    }

    public void inserirFim(int dado) {
        if (inicio == null) {
            inserirInicio(dado);
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = new No(dado);
            tamanho++;
        }
    }

    public void inserirMeio(int dado, int posicao) {
        if (posicao <= 0) {
            inserirInicio(dado);
        } else if (posicao >= tamanho) {
            inserirFim(dado);
        } else {
            No novoNo = new No(dado);
            No atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
            tamanho++;
        }
    }

    public void removerInicio() {
        if (inicio != null) {
            inicio = inicio.proximo;
            tamanho--;
        }
    }

    public void removerFim() {
        if (inicio != null) {
            if (inicio.proximo == null) {
                inicio = null;
            } else {
                No atual = inicio;
                while (atual.proximo.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = null;
            }
            tamanho--;
        }
    }

    public void removerMeio(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        } else if (posicao == 0) {
            removerInicio();
        } else if (posicao == tamanho - 1) {
            removerFim();
        } else {
            No atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
            tamanho--;
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void imprimir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        // Inserir alguns números na lista
        lista.inserirInicio(5);
        lista.inserirFim(10);
        lista.inserirMeio(7, 1);

        // Imprimir a lista
        lista.imprimir();  // Deve imprimir: 5 7 10

        // Remover alguns números da lista
        lista.removerInicio();
        lista.removerFim();
        lista.inserirInicio(3);
        lista.inserirFim(8);

        // Imprimir a lista novamente
        lista.imprimir();  
    	}
	}

