import { Republica } from './republica';

export class ReceitaDespesa {
    id: number;
    republica: Republica;
    tipo: String;
    descricao: String;
    valor: number;
    periodo: String;
    divisao: boolean;
    valorDividido: number;
    dataLancamento: String;
    dataVencimentoRecebimento: String;
    efetivado: boolean;
}
