import { Component } from '@angular/core';
import { BookClubService } from './book-club.service';
import { Member } from './member';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'bookclub-frontend';

  newMember: Member = { name: "", booksRead: 0, foundingMember: false } as any as Member;
  Members: Member[] = [];

  constructor(private BookService: BookClubService) {

    this.loadMembers();

  }

  loadMembers(): void {
    this.BookService.getAllMembers().subscribe((data: Member[]) => {
      this.Members = data;
    });
   
  };

  readBook(M: Member){
    M.booksRead++;
    this.BookService.updateMember(M).subscribe((data: Member) => { 
      this.loadMembers();
    });

  }

  kickMember(M: Member){
    this.BookService.removeMember(M).subscribe(() =>{
      this.loadMembers();
     }) ;
  }


  onSubmit(): void {
    this.BookService.addMember(this.newMember).subscribe(() => {
      this.loadMembers();
    });
  }
}
