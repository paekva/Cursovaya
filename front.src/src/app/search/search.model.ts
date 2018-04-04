export class SearchRequest
{
    constructor(
      public subject: string,
      public zoo?: string,
      public type?: string,
      public date?: Date
    ) { }
}