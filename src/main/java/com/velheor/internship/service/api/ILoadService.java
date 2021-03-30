package com.velheor.internship.service.api;

import com.velheor.internship.models.Load;
import java.util.UUID;

public interface ILoadService extends Crud<Load> {

    Load findById(UUID id);
}
