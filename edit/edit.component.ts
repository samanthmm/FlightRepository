import { Component, OnInit } from '@angular/core';
import{FormControl,FormGroup,Validators,FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  constructor(
    private formBuilder:FormBuilder
  ) { }
  profileForm=this.formBuilder.group({
    firstName: [''],
    lastName: [''],
      address: [''],
      phoneNumber:[''],
      panNumber:[''],
      gstnNumber:['']
    });
  ngOnInit(): void {
    
  }

}
