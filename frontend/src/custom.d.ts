/* Modulo responsável por corrigir caminho de importação de imagens */

declare module "*.svg" {
    const content: any;
    export default content;
  }